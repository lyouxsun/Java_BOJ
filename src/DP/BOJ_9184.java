package dp;

import java.io.*;

public class BOJ_9184 {
    static int a, b, c;
    static long[][][] dp = new long[21][21][21];        // a,b,c

    public static void main(String[] args) throws IOException {
        dp[0][0][0] = 1;

        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    if (a == 0 || b == 0 || c == 0) {
                        dp[a][b][c] = 1;
                        continue;
                    }
                    dp[a][b][c] = w(a, b, c);
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = br.readLine().split(" ");
            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[1]);
            c = Integer.parseInt(line[2]);

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + dp[0][0][0]);
                continue;
            }
            if (a > 20 || b > 20 || c > 20) {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + dp[20][20][20]);
                continue;
            }
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + dp[a][b][c]);
        }
    }

    private static long w(int a, int b, int c) {
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
