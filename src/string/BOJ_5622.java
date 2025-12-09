package string;

import java.util.Scanner;

public class BOJ_5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int sum=0;

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='A'||input.charAt(i)=='B'||input.charAt(i)=='C'){
                sum+=3;
            } else if(input.charAt(i)=='D'||input.charAt(i)=='E'||input.charAt(i)=='F'){
                sum+=4;
            } else if(input.charAt(i)=='G'||input.charAt(i)=='H'||input.charAt(i)=='I'){
                sum+=5;
            } else if(input.charAt(i)=='J'||input.charAt(i)=='K'||input.charAt(i)=='L'){
                sum+=6;
            } else if(input.charAt(i)=='M'||input.charAt(i)=='N'||input.charAt(i)=='O'){
                sum+=7;
            } else if(input.charAt(i)=='P'||input.charAt(i)=='Q'||input.charAt(i)=='R'||input.charAt(i)=='S'){
                sum+=8;
            } else if(input.charAt(i)=='T'||input.charAt(i)=='U'||input.charAt(i)=='V'){
                sum+=9;
            } else if(input.charAt(i)=='W'||input.charAt(i)=='X'||input.charAt(i)=='Y'||input.charAt(i)=='Z'){
                sum+=10;
            }
        }
        System.out.println(sum);
    }
}
