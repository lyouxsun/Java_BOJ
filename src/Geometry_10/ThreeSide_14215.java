package Geometry_10;

import java.util.Scanner;

public class ThreeSide_14215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,max = 0;
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int sum = x+y+z;

        if(max<x) max = x;
        if(max<y) max = y;
        if(max<z) max = z;

        if(max<sum-max) System.out.println(sum);
        else {
            for(i=0;;i++){
                if(2*max<sum) break;
                else {
                    max--;
                    sum--;
                }
            }
            System.out.println(sum);
        }
    }
}
