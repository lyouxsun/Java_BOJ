package measure_multiple_decimal;

import java.util.Scanner;

public class BOJ_11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int input = sc.nextInt();
        int n=2;
        if(input==1) return;

        while(n<=input){
            if(input==n) {
                sb.append(n);
                break;
            }
            if(input%n==0) {
                input/=n;
                sb.append(n+"\n");
            }
            else n++;
        }
        System.out.println(sb);
    }
}
