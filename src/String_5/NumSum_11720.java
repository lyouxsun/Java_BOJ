package String_5;

import java.util.Scanner;

public class NumSum_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        String numString = sc.next();
        char[] numChar = new char[inputNum];
        int sum=0;

        for(int i=0;i<inputNum;i++){
            //System.out.println(numString.charAt(i));
            sum+= numString.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}
