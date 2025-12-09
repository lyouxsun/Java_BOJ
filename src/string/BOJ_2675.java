package string;

import java.util.Scanner;

public class BOJ_2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();

        for(int i=0;i<cycle;i++){

            int loop = sc.nextInt();
            String str = sc.next();

            for(int j=0;j<str.length();j++){

                for(int k=0;k<loop;k++){
                    System.out.print(str.charAt(j));
                }
            }
            System.out.print("\n");
        }
    }
}
