package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
    static private int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if (N == 3) {
            System.out.println("***");
            System.out.println("* *");
            System.out.println("***");
            return;
        }

        int x = 1;
        int y = 1;
        boolean flag;


        while(y<=N) {
            flag = false;
            // 가운데에 있는 큰 사각형 탐색
            // 그것보다 작은 자잘자잘 사각형 탐색
            int tmp_N = N/3;
            int nx = x;
            int ny = y;
            while ((!flag) && (tmp_N >= 3)) {
                if ((tmp_N < ny) && (ny <= 2 * tmp_N) && (tmp_N < nx) && (nx <= 2 * tmp_N)) {
                    flag = true;
                    break;
                }
                nx = x % tmp_N;
                ny = y % tmp_N;
                tmp_N /= 3;
            }


            if (flag) {
                // 1. 만약 빈칸인 경우 => 아무것도 출력 안해버리기~
                sb.append("   ");
            } else {
                // 2. 빈칸이 아닌 경우 => 출력 해버리기~
                if (y % 3 == 2) {
                    sb.append("* *");
                } else {
                    sb.append("***");
                }
            }


            // 다음판으로 넘길 때
            if (x + 3 > N) {
                sb.append("\n");
                y += 1;
                x = 1;
            } else {
                x += 3;
            }
        }

        System.out.print(sb.toString());
    }
}
