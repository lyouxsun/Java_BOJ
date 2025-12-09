package two_dimensional_array;

import java.util.Scanner;

public class BOJ_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();
        int[][] arr = new int[cycle][2];
        int[][] entire = new int[100][100];
        int sum=0;

        //색종이 모서리 입력받기
        for(int i=0;i<cycle;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        //색종이 있는 부분에 1 넣기 (겹치건 말건 상관없이)
        for(int i=0;i<cycle;i++) {
            int tmp1 = arr[i][0]-1;
            int tmp2 = arr[i][1]-1;

            for(int j=0;j<10;j++) {
                for (int k = 0; k < 10; k++) {
                    entire[tmp1 + j][tmp2 + k] = 1;
                }
            }
        }

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                sum+=entire[i][j];
            }
        }
        System.out.println(sum);
    }
}
