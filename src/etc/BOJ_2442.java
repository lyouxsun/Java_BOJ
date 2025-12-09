package etc;

import java.util.Scanner;

public class BOJ_2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int tmp = 0;

        for(int i=input;i>0;i--){
            for (int j=0;j<tmp;j++){
                System.out.print(" ");
            }
            for(int k=0;k<2*i-1;k++){
                System.out.print("*");
            }
            if(i==1) break;
            System.out.println();
            tmp++;
        }
    }
}
