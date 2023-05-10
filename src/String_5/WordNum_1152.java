package String_5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class WordNum_1152 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       int cnt=0;

        StringTokenizer st = new StringTokenizer(input, " ");
        while(st.hasMoreTokens()){
            st.nextToken();
            cnt++;
        }
        System.out.println(cnt);
    }
}
