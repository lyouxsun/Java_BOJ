package bit_masking;

import java.io.*;
import java.util.*;

public class BOJ_2961 {
    static int N = 0;
    static int[][] ing;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ing = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            ing[i][0] = Integer.parseInt(line[0]);
            ing[i][1] = Integer.parseInt(line[1]);
        }

        List<int[]> combination = new ArrayList<>();
        comb(combination);

        for (int[] ints : combination) {
            int now_s = 1;
            int now_b = 0;

            for (int i = 0; i < N; i++) {
                if(ints[i] == 1) {
                    now_s *= ing[i][0];
                    now_b += ing[i][1];
                }
            }
            answer = Math.min(answer, Math.abs(now_s - now_b));
        }
        System.out.println(answer);
    }

    private static void comb(List<int[]> combination) {
        // 2**N 개의 모든 조합을 생각하기
        int total = (int) Math.pow(2, N);
        for (int i = 1; i < total; i++) {
            int[] result = new int[N];
            int now = i;
            for (int j = 0; j < N; j++) {
                if (now % 2 == 1) {
                    result[j] = 1;
                }
                now /= 2;
            }
            combination.add(result);
        }
    }
}
