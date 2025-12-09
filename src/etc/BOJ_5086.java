package etc;

import java.util.Scanner;

public class BOJ_5086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();

            if (input1 == 0 && input2 == 0) break;
            else if (input2 / input1 > 0 && input2 % input1 == 0) System.out.println("factor");
            else if (input1 / input2 > 0 && input1 % input2 == 0) System.out.println("multiple");
            else System.out.println("neither");
        }
    }
}
