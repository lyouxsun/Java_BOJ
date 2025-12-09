package graph.path_search.dfs.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941_backTracking {
    static int[] array = new int[25];
    static boolean[] visited = new boolean[25];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받아서 이다솜파 -> 1, 나머지 -> 0 으로 1차원 배열에 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dasomCnt = 0;

        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                if (line[j].equals("S")) {
                    array[i * 5 + j] = 1;
                    dasomCnt += 1;
                }
            }
        }

        // 만약 다솜이파가 전체에서 4명 미만이라면, 그 즉시 종료
        if (dasomCnt < 4) {
            System.out.println(0);
            return;
        }

        // DFS(백트래킹)로 순회하며 모든 7자리를 중복없이 탐색
        for (int start = 0; start < 25; start++) {
            visited[start] = true;
            back_tracking(start, 1, array[start]);
            visited[start] = false;
        }


        System.out.println(answer);
    }

    private static void back_tracking(int nowIdx, int totalNum, int sNum) {
        if (totalNum - sNum > 3) return;        // 가지치기 : 이도연파가 4명 이상인 경우

        // 종료 조건을 만족하는 경우
        if (totalNum == 7 && sNum >= 4) {
            if (isConnected()) {
                answer++;
            }
            return;
        }

        // 2번째 호출부터는~
//        어떤 점들을 방문해야 중복없이 탐색할 수 있을까
        if (nowIdx + 1 >= 25) {
            return;
        }

        // 1. nowIdx +1 을 방문하는 경우
        visited[nowIdx + 1] = true;
        back_tracking(nowIdx + 1, totalNum + 1, sNum + (array[nowIdx + 1]));
        visited[nowIdx + 1] = false;

        // 2. nowIdx + 1 을 방문하지 않는 경우
        back_tracking(nowIdx + 1, totalNum, sNum);
    }


    private static boolean isConnected() {
//      visited에서 모든 점들이 이어져있는지 확인하기
        int[] dy = new int[]{-1, 0, 0, 1};
        int[] dx = new int[]{0, -1, 1, 0};

//        System.out.println("========== isConnected ==========");
//        for (int i = 0; i < 25; i++) {
//            if (visited[i]) System.out.print(i + " ");
//        }
//        System.out.println("\n===================================\n");

        boolean[] validated = new boolean[25];
        int start = 0;
        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                start = i;
                validated[start] = true;
                break;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int num = 1;

        while (!q.isEmpty()) {
            int nowIdx = q.poll();
            int y = nowIdx / 5;
            int x = nowIdx % 5;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                    int nextIdx = 5 * ny + nx;
                    if (visited[nextIdx] && !validated[nextIdx]) {
                        q.offer(nextIdx);
                        validated[nextIdx] = true;
                        num++;
                    }
                }
            }
        }
        return num == 7;
    }

}
