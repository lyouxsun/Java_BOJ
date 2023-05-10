package guitar;

import java.util.Scanner;

public class Star3_2440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int tmp = input;

        for(int i=0;i<input;i++){
            /*
            for(int k=0;k<i;k++){
                System.out.print(" ");
            }

             */
            for(int j=tmp;j>0;j--){
                System.out.print("*");
            }

            tmp--;
            if(i==input-1) break;
            System.out.println();
        }
    }
}
