package String_5;

import java.util.Scanner;

public class FindAlphabet_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] alphabet = new int[26];   //각 알파벳의 처음 위치를 저장, 출력하는 배열
        int tmp;
        /**
         * str.charAt(i) 무슨 알파벳인지 알아내서 해당 alphabet 배열이랑 매치시키고,
         * 알파벳이 처음 나온 위치를 출력해야됨
         * 그리고 해당되는 배열에 그 수를 넣어야됨 (없으면 -1로 초기화하기)
         */
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            tmp = str.charAt(i) - '0';  //i위치에 오는 알파벳의 아스키코드-0
            //System.out.println(tmp);
            tmp -= 49;

            if (alphabet[tmp] == -1) {
                alphabet[tmp] = i;
            }
        }

        for(int i=0;i<26;i++){
            System.out.print(alphabet[i]+" ");
        }
    }
}

