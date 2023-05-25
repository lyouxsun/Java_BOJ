package MeasureMultipleDecimal_9;

import java.util.Scanner;

public class Decimal_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int sum=0;
        int min=0;
        boolean decimal;

        for(int i=start;i<=end;i++){
            decimal=true;
            //tf=0;
            if(i==1) continue;
            for(int j=2;j<i;j++){
                if(i%j==0) {
                    decimal=false;
                    //소수가 아닐 때
                    break;
                }
            }
            if(i==2||decimal){    //i가 소수이면
                sum+=i;
                if(min==0) min=i;
            }
        }
        if(sum==0) System.out.println("-1");
        else System.out.println(sum+"\n"+min);
    }
}
