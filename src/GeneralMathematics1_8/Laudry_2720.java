package GeneralMathematics1_8;

import java.util.Scanner;

public class Laudry_2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();

        for(int i=0;i<cycle;i++){
            int change = sc.nextInt();      //거스름돈 얼마 줘야 하는지
            int Q=0;
            int D=0;
            int N=0;
            if(change/25!=0){
                Q=change/25;
                change-=25*Q;
                //System.out.println("changeQ : "+change);
            }
            if(change/10!=0){
                D=change/10;
                change-=10*D;
                //System.out.println("changeD : "+change);
            }
            if(change/5!=0){
                N=change/5;
                change-=5*N;
                //System.out.println("changeN : "+change);
            }
            int P = change;
            //System.out.println("changeP : "+change);
            System.out.println(Q+" "+D+" "+N+" "+P);
        }
    }
}
