package graph.path_search.dfs.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2661 {
    static int[] array;
    static int N;
    static boolean end = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            array[0] = i;
            back_tracking(1, i);
            array[0] = 0;
        }
    }

    private static void back_tracking(int depth, int before) {
        if (conflict(depth)) {
            return;
        }

        if (depth == N) {
            if (!conflict(N)) {
                end = true;
                for (int i = 0; i < N; i++) {
                    System.out.print(array[i]);
                }
                System.exit(0);
            }
            System.out.print("\n답 X : ");
            for (int i = 0; i < N; i++) {
                System.out.print(array[i]);
            }
            return;
        }


        for (int i = 1; i <= 3; i++) {
            if (before != i) {
                array[depth] = i;
                back_tracking(depth + 1, i);
                array[depth] = 0;
            }
        }
    }

    private static boolean conflict(int N) {
        // 겹치는 부분수열이 있으면 true, => 나쁜수열
        // 부분수열이 없으면 false => 좋은수열
        int MAX_LENGTH = N / 2;
        for (int len = 2; len <= MAX_LENGTH; len++) {
            int last_idx = N - 2 * len;
            for (int start = 0; start <= last_idx; start++) {
                int first_start = start;
                int second_start = start + len;
                boolean flag = true;
                for (int i = 0; i < len; i++) {
                    if (array[first_start + i] != array[second_start + i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
