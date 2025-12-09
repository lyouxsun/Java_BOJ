package hard;

import java.util.Scanner;

public class BOJ_2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for(int i=1;i<=input;i++){
            StringBuilder sb1 = new StringBuilder();
            for(int k=input-i;k>0;k--){
                sb1.append(" ");
            }

            for(int j=0;j<2*i-1;j++){
                sb1.append("*");
            }
            System.out.print(sb1);
            System.out.println();
        }


        for(int i=input-1;i>0;i--){
            StringBuilder sb3 = new StringBuilder();
            for(int k=input-i;k>0;k--){
                sb3.append(" ");
            }

            for(int j=0;j<(2*i-1);j++){
                sb3.append("*");
            }
            System.out.print(sb3+"\n");
        }
    }
}

