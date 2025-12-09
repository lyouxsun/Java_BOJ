package etc;

import java.util.Scanner;

public class BOJ_2953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr=new int[5];
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                arr[i]+=sc.nextInt();
            }
        }
        int max = arr[0];
        int index=1;
        for(int i=1;i<5;i++){
            if(max<arr[i]) {
                max=arr[i];
                index = i+1;
            }
        }
        System.out.println(index+" "+max);
    }
}
