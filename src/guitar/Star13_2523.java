package guitar;

import java.util.Scanner;

public class Star13_2523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for(int i=0;i<2*input-1;i++){
            if(i<input){
                for(int j=0;j<i+1;j++) System.out.print("*");
                System.out.println();
            }
            if(i>=input){
                int tmp = 2*input-1-i;
                for(int j=0;j<tmp;j++) System.out.print("*");
                if(i<2*input-2) System.out.println();
            }
        }
    }
}
