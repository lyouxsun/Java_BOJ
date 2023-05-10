package guitar;

import java.util.Scanner;

public class Star20_10995 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 0; i < input; i++) {
            if (i % 2 == 0) {
                for (int k = 0; k < input; k++)
                    System.out.print("* ");
            } else {
                for (int k = 0; k < input; k++)
                    System.out.print(" *");
            }
            if (i == input - 1) break;
            System.out.println();
        }

    }
}
