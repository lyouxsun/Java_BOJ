package guitar;

import java.util.Scanner;

public class Star14_2556 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for(int i=0;i<input;i++){
            if(i==0 || i==input-1){
                for(int j=0;j<input;j++) System.out.print("*");
                System.out.println();
            }
            else{
                for(int j=0;j<input;j++) System.out.print("*");
                System.out.println();
            }
        }
    }
}
