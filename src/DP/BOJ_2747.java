package dp;

import java.io.*;

public class BOJ_2747 {
    static int N;
    static int[] dp = new int[46];;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 46; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
