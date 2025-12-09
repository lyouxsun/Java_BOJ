package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        Integer arr[]=new Integer[input.length()];
        for(int i=0;i<input.length();i++) {
            int tmp = Integer.parseInt(String.valueOf(input.charAt(i)));
            arr[i]=tmp;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<input.length();i++) sb.append(arr[i]);
        System.out.println(sb);
    }
}
