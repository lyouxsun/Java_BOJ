package dp;

import java.io.*;
import java.util.*;

public class BOJ_7579 {
    static int N;
    static int M;
    static int[][] app;
    static long[] dp;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        app = new int[N][2];
        int costSum = 0;
        String[] memory = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            app[i][1] = Integer.parseInt(memory[i]);
        }

        String[] cost = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            app[i][0] = Integer.parseInt(cost[i]);
            costSum += app[i][0];
        }

//        Arrays.sort(app,  (o1, o2) -> {
//            return (o1[0] != o2[0]) ? (o1[0]-o2[0]): (o1[1] - o2[1]);
//        });
//        for (int i = 0; i < N; i++) {
//            System.out.println("app[" + i + "] 의 비용 = " + app[i][0] + ", 메모리 = " + app[i][1]);
//        }

        /** 처음에 시도한 잘못된 접근법
         * dp[i][0] = 0~i번째 앱을 고려했을 때, 비용 합의 최솟값
         * dp[i][1] = 0~i번째 앱을 고려하여 최소 비용을 구했을 때, 메모리 합
         */
        /** 두번째 접근법
         * dp[i] = 비용이 i일 때, 확보할 수 있는 최대 메모리
         */
        dp = new long[costSum + 1];
//        for (int i = 0; i < N; i++) {
//            if (dp[app[i][0]] == 0) {
//                dp[app[i][0]] = app[i][1];
//            } else {
//                dp[app[i][0]] = Math.max(dp[app[i][0]], app[i][1]);
//            }
//        }

        for (int i = 0; i <= costSum; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != 0 && dp[i-j] != 0) {
                    dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
                }
            }
        }

        for (int i = 0; i <= costSum; i++) {
            System.out.println("dp["+i+"] = " + dp[i]);
        }

        for (int i = 0; i < costSum; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
