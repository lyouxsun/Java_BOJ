package string;

import java.util.Scanner;

public class BOJ_27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num = sc.nextInt();
        System.out.println(input.charAt(num-1));
    }
}
