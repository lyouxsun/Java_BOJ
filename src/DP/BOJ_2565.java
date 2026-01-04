package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 중요 : 교차 원리를 살펴보면, 교차하지 않는 전기줄을 만들기 위해서는
 * 1. 전깃줄을 a를 기준으로 정렬한 후에
 * 2. b를 증가수열로 만들면 된다.
 * dp[i] = 0~i 까지의 전깃줄을 고려했을 때, 최장 증가수열의 길이
 */
public class BOJ_2565 {
    static int N;
    static int[][] lines;

    public static void main(String[] args) throws IOException {
        // 1. 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            lines[i][0] = Integer.parseInt(line[0]);
            lines[i][1] = Integer.parseInt(line[1]);
        }

        // new 2. 전깃줄을 기준에 맞게 정렬
        // 2-1. a를 기준으로 정렬
        Arrays.sort(lines, (o1, o2) ->
                o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]
        );

        // 3. DP 테이블 채우기 : dp[i] = 0~i 까지의 전깃줄을 고려했을 때, b의 최장 증가수열의 길이
        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i]= 1;
            for (int j = i; j >= 0; j--) {
                if (lines[j][1] < lines[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(N - ans);
    }
}
