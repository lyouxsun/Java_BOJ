package string;

import java.util.Scanner;

public class BOJ_9068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();
        for(int i=0;i<cycle;i++){
            String str = sc.next();
            System.out.println(str.charAt(0)+ "" +str.charAt(str.length()-1));
        }
    }
}
