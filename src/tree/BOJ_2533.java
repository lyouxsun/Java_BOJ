package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO. DP로 풀기
// dp[i][0] = i번째 노드가 루트인 서브트리에서 i노드가 얼리어답터가 아닌 경우, 최소 얼리어답터 수
// dp[i][1] = i번째 노드가 루트인 서브트리에서 i노드가 얼리어답터인 경우, 최소 얼리어답터 수
public class BOJ_2533 {
    static int N;
    static List<List<Integer>> adj = new ArrayList<>();
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static int[] order;             // order[i] = DFS할 때 i번째로 탐색한 노드의 값
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        // 1. 입력받아서 인접 노드를 인접 리스트 형태로 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 2. 그래프 탐색을 통해 트리 구조 구하기 (a 노드의 부모가 누구인지 & 자식이 누구인지)
        // 노드1을 루트노드로 삼고 -> 1부터 dfs 진행
        for (int i = 1; i <= N; i++) {
            tree.put(i, new ArrayList<>());
        }
        order = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        dfs(1, visited);

        // 3. 리프 노드 -> 루트 노드까지 순회하면서 dp 테이블 채우기
        int[][] dp = new int[N + 1][2];
        for (int i = N; i >= 1; i--) {
            int now = order[i];
            if (tree.get(now).isEmpty()) {
                dp[now][0] = 0;
                dp[now][1] = 1;
            } else {
                dp[now][1] = 1;        // 나 자신이 얼리어답터인 경우도 포함해야함
                for (Integer child : tree.get(now)) {
                    // TODO. 부모가 선택 -> 자식은 무조건 비선택 (X), 부모가 비선택 -> 자식은 무조건 선택 (O)
                    dp[now][0] += dp[child][1];
                    dp[now][1] += Math.min(dp[child][0], dp[child][1]);
                }
            }
        }


        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }


    // 재귀 (DFS)로 트리 구조 구하기
    private static void dfs(int now, boolean[] v) {
        // 1. BASE CONDITION (종료 조건)

        // 2. 방문 처리
        order[idx++] = now;
        v[now] = true;

        // 3. 다음꺼 진행
        for (Integer next : adj.get(now)) {
            if (!v[next]) {
                tree.get(now).add(next);
                dfs(next, v);
            }
        }

    }

}
