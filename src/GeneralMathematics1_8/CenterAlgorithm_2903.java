package GeneralMathematics1_8;

import java.util.Scanner;

public class CenterAlgorithm_2903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M=2;

        for(int i=0;i<N;i++){
            M=2*M-1;
        }
        System.out.println(M*M);
    }
}
