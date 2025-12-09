package etc;

import java.util.Scanner;

public class BOJ_2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int tmp = input;
        int tmp1 = input;

        for(int i=0;i<2*input-1;i++){
            if(i<input) {
                for (int j = 0; j < i+1; j++) {
                    System.out.print("*");
                }
                for (int k = 0; k < 2 * (tmp - 1); k++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i+1; j++) {
                    System.out.print("*");
                }
                System.out.println();
                tmp--;
            }

            if(i>=input){
                for (int j = 0; j < tmp1-1; j++) {
                    System.out.print("*");
                }
                for (int k = 0; k < 2 * (i-input+1) ; k++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < tmp1-1; j++) {
                    System.out.print("*");
                }
                if(i==2*input-2) break;
                System.out.println();
                tmp1--;
            }
        }
    }
}
