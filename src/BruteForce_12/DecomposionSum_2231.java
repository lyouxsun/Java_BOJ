package BruteForce_12;

import java.util.Scanner;
public class DecomposionSum_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();       //같은 입력값 String형
        int length = input.length();
        long inputLong = Long.parseLong(input); //입력값 정수형
        long check;

        if (inputLong<=10 && inputLong%2==0) System.out.println(inputLong/2);
        else if(inputLong<10) {
            System.out.println("0");
        }
        else {
            long start = inputLong - length * 9;
            while (true) {
                check = start;
                //System.out.println("start : "+start);
                String tmp = String.valueOf(start);
                for (int i = 0; i < tmp.length(); i++) {
                    check += Character.getNumericValue(tmp.charAt(i));
                    /**
                     * 왜 Integer.parseInt(tmp.charAt(i))는 오류가 나고
                     * Integer.parseInt(String.valueOf(tmp.charAt(i)))는 오류가 안 날까
                     */
                }
                //System.out.println("check : "+check);
                if (inputLong == check) {
                    System.out.println(start);
                    break;
                }
                else if(start>inputLong){
                    System.out.println("0");
                    break;
                }
                else start++;
            }
        }
    }
}
