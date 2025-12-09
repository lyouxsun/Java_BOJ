package etc;

import java.util.Scanner;

public class BOJ_10991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int tmp1 = input;
        int tmp2 = 1;

        for(int i=0;i<input;i++){
            for(int j=0;j<tmp1-1;j++) {
                System.out.print(" ");
            }
            for(int k=0;k<tmp2;k++){
                System.out.print("* ");
            }
            if(i==input-1) break;
            System.out.println();
            tmp1--;
            tmp2++;
        }
    }
}
