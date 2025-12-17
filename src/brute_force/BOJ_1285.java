package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 브루트포스 -> 1 <= 2 ** 2N <= 1,000,000,000,000
//         -> 근데 시간제한 6초면 무조건 부르트포스가 맞는거같긴 한데;;
// DP -> 순서는 없다.
//    1. 처음 T의 개수 세기
//    2. 뒤집었을 때의 T의 개수, 안 뒤집었을 때의 T의 개수 세기
//    3.
public class BOJ_1285 {
    static int N;
    static int[][] array;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char now = line.charAt(j);
                if (now == 'H') {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }

//        printArray();

        // 모든 행에 대해서, 뒤집을 때 & 뒤집지 않을 때 배열 계산
        for (int i = 0; i < N; i++) {
            // 뒤집지 않은 상태에서 한번
            flip_row(i);
            back_tracking(i + 1);
            // 원상복구한 상태에서 한번
            flip_row(i);
            back_tracking(i + 1);
        }

        System.out.println(answer);
    }

    private static void back_tracking(int idx) {
        if (idx == N) {
            return;
        }

        // 성공 종료 : answer의 값 갱신하기
        count_t();

        // 뒤집지 않은 상태에서 한번
        flip_row(idx);
        back_tracking(idx + 1);

        // 원상복구한 상태에서 한번
        flip_row(idx);
        back_tracking(idx + 1);
    }

    private static void count_t() {
        int result = 0;
        for (int c = 0; c < N; c++) {
            int tCount = 0;
            for (int r = 0; r < N; r++) {
                tCount += array[r][c];
            }
            result += Math.min(tCount, N - tCount);
        }
        answer = Math.min(answer, result);
    }

    private static void flip_row(int i) {
        for (int j = 0; j < N; j++) {
            array[i][j] = 1 - array[i][j];
        }
    }


    private static void printArray() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
