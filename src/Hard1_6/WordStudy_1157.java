package Hard1_6;

import java.util.Scanner;

/**
 * 입력받은 문자열을 모두 대문자로 바꿔주기 -> toUpperCase() 메서드 사용
 */
public class WordStudy_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String str = input.toUpperCase();
        int[] cnt = new int[26];

        //출현횟수 count해서 그 값을 저장하는 cnt배열
        for(int i=0;i<str.length();i++){
            int tmp = str.charAt(i)-65;
            //System.out.println("tmp : "+tmp);
            cnt[tmp]++;
        }

        int max=0;
        int maxCnt=1;
        //많이 출현한 배열의 인덱스를 저장
        for(int i=1;i<26;i++){
            if(cnt[i]==0) continue;
            else if(cnt[max]<cnt[i]){
                max=i;
                maxCnt=1;
            } else if(cnt[max]==cnt[i]){
                maxCnt++;
            }
        }
        //System.out.println("\nmax : "+max);
        //System.out.println("cnt[max] : "+cnt[max]);
        //System.out.println("maxCnt : "+ maxCnt);
        if(maxCnt>1) System.out.println("?");
        else if(maxCnt==1) System.out.printf("%c", max+65);
    }
}
