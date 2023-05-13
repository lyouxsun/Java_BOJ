package guitar;

import java.util.Scanner;

public class ThreeKangaroo_2965 {
    public static void main(String[] args) {
        // 359
        //3 4 5 6 7 8 9
        //가장 큰 차이가 나는 인접한 수의 차-1

        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int input3 = sc.nextInt();
        int max=input2-input1;

        if(input3-input2>max) max = input3-input2;

        System.out.println(max-1);
    }
}
