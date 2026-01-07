package dp;

import java.io.*;

public class BOJ_2133 {

    static int N;
    static int[] dp = new int[31];

    // 이 문제를 어떻게 쪼개야 각각을 독립적으로 분리할 수 있을까?
    // dp[i] = 기본 패턴 + 2칸씩 늘릴 때마다 생기는 특수패턴
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = 1;
        dp[2] = 3;      // 기본 패턴
        for (int i = 4; i <= 30; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
}
