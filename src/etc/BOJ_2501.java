package etc;

import java.util.Scanner;

public class BOJ_2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] measure = new int[input];
        int cnt = 1;
        for(int i=1;i<=input;i++){
            if(input%i==0) {
                measure[cnt]=i;
                cnt++;
            }
        }
        int order = sc.nextInt();
        System.out.println(measure[order]);
    }
}
