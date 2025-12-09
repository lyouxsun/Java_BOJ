package math;

import java.util.Scanner;

public class BOJ_2292 {
    public static void main(String[] args) {
        /**
         * 1: 1
         * 2: 2~7
         * 3: 8~19
         * 4: 20~37
         * 5: 38~61
         */

        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        long tmp = (input+4)/6;

        if(tmp==0) System.out.println("1");
        else if(tmp==1) System.out.println("2");
        else {
            int tmp2 = 2;
            int i = 2;
            while (true) {
                if (tmp2 <= tmp && tmp < tmp2 + i) {
                    break;
                }
                tmp2 += i;
                i++;
            }
            System.out.println(i + 1);
        }
    }
}
