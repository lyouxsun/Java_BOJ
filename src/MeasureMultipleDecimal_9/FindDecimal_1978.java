package MeasureMultipleDecimal_9;

import java.util.Scanner;

public class FindDecimal_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt=0;
        for(int i=0;i<N;i++){
            int input = sc.nextInt();
            int tmp=0;
            if(input==1) continue;
            if(input==2){
                cnt++;
                continue;
            }
            for(int j=2;j<input;j++){
                if(input%j==0) {
                    tmp=1;
                    break;
                }
            }
            if(tmp==0)cnt++;
        }
        System.out.println(cnt);
    }
}
