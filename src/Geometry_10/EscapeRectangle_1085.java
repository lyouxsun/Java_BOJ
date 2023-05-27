package Geometry_10;

import java.util.Scanner;

public class EscapeRectangle_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt()-arr[0];
        arr[3] = sc.nextInt()-arr[1];

//경계선까지의 최솟값 : x, y, h-y, w-x
        int min = arr[0];
        for(int i=1;i<4;i++) if(min>arr[i]) min=arr[i];

        System.out.println(min);
    }
}
