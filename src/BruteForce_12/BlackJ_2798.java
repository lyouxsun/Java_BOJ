package BruteForce_12;

import java.util.Scanner;

public class BlackJ_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();
        int goal = sc.nextInt();
        int[] numArr = new int[cycle];
        for(int i=0;i<cycle;i++){
            numArr[i]=sc.nextInt();
        }
        int sub=goal;
        int result=0;

        for(int i=0;i<cycle-2;i++){
            for(int j=i+1;j<cycle-1;j++){
                for(int k=j+1;k<cycle;k++){
                    if(i==j||j==k||i==k) continue;
                    int tmp=numArr[i]+numArr[j]+numArr[k];
                    if(0<=(goal-tmp) && (goal-tmp)<sub){
                        result=tmp;
                        sub=goal-tmp;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
