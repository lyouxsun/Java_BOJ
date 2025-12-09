package etc;

import java.util.Scanner;

public class BOJ_2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int tmp = input;

        for(int i=0;i<input;i++){       //줄 개수
            for(int k=0;k<i;k++) {        //줄마다 띄어쓰기
                System.out.print(" ");
            }
            for(int j=0;j<(2*tmp-1);j++){       //한 줄당 별 개수
                System.out.print("*");
            }
            System.out.println();
            tmp--;
        }
        tmp=2;
        for(int i=0;i<input-1;i++){       //줄 개수
            for(int k=0;k<input-2-i;k++) {        //줄마다 띄어쓰기
                System.out.print(" ");
            }
            for(int j=0;j<(2*tmp-1);j++){       //한 줄당 별 개수
                System.out.print("*");
            }
            if(i==input-2) break;
            else System.out.println();
            tmp++;
        }
    }
}
