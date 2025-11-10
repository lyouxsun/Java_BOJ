package graph.path_search.dfs;

public class PG_네트워크 {
    int[] v;
    int num;

    public int solution(int n, int[][] computers) {
        v = new int[n];
        num = n;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (v[i] == 0) {
                answer++;
                v[i] = 1;
                dfs(i, computers);
            }
        }
        return answer;
    }

    void dfs(int c, int[][] computers) {
        for(int i = 0; i < num; i++) {
            if (computers[c][i] == 1 && v[i] == 0) {
                v[i] = 1;
                dfs(i, computers);
            }
        }
    }
}