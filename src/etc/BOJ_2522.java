package etc;

import java.util.Scanner;

public class BOJ_2522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int tmp = input-1;
        for(int i=0;i<2*input-1;i++){
            if(i<input) {
                for (int j = 0; j < tmp; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < input - tmp; k++) {
                    System.out.print("*");
                }
                System.out.println();
                tmp--;
            }
            else if(i==input) tmp =input-1;
            if(i>=input) {
                for (int j = 0; j < input-tmp; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < tmp; k++) {
                    System.out.print("*");
                }
                if(i==2*input-2) break;
                else System.out.println();
                tmp--;
            }
        }
    }
}
