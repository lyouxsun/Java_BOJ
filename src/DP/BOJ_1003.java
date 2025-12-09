package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀, 피보나치 수열
public class BOJ_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cycle = Integer.parseInt(br.readLine());

        int[][] arr = new int[41][2];

        for (int i = 0; i < 41; i++) {
            if (i == 0) {
                arr[i][0]++;
                break;
            } else if (i == 1) {
                arr[i][1]++;
                break;
            }
            i -= 1;
            i -= 2;
        }

        for (int i = 0; i <= 40; i++) {
            //fibo(i);
        }
        for (int i = 0; i < cycle; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N][0] + " " + arr[N][1]);
        }
    }
}
