package dp;

import java.io.*;

public class BOJ_11049 {
    static int N;
    static long[][] array;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new long[N+1][2];
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(line[0]);
            array[i][1] = Integer.parseInt(line[1]);
        }


        // dp 테이블 초기화하기
        dp = new long[N+1][N+1];

        // 1. 인접한 노드부터
        for (int i = 1; i < N; i++) {
            dp[i][i+1] = array[i][0] * array[i][1] * array[i+1][1];
        }

        // 2. 범위를 넓혀가면서
        for (int size = 2; size < N; size++) {
            for (int start = 1; start+size <= N; start++) {
                dp[start][start+size] = Long.MAX_VALUE;
                for (int i = 0; i < size; i++) {
                    dp[start][start+size] = Math.min(
                            dp[start][start+size],
                            dp[start][start+i] + dp[start+i+1][start+size] + array[start][0] * array[start+i+1][0] * array[start+size][1]
                            );
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}

