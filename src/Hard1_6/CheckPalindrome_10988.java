package Hard1_6;

import java.util.Scanner;
public class CheckPalindrome_10988 {

    static int check(String str) {
        for (int i = 0; i < (str.length() / 2 + 1); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(check(input));
    }
}
