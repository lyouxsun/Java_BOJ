package DataStructure.SectionSum;

import java.util.Scanner;

public class SectionSum4_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cycle = sc.nextInt();
        int[] sumArr = new int[num];
        sumArr[0] = sc.nextInt();
        for(int i=1;i<num;i++){
            sumArr[i]=sumArr[i-1]+sc.nextInt();
        }
        for(int i=0;i<cycle;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            if(start==1){
                System.out.println(sumArr[end-1]);
            }
            else System.out.println(sumArr[end-1]-sumArr[start-2]);
        }
    }
}
