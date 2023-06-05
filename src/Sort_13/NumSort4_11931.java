package Sort_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NumSort4_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        Arrays.sort(arr, Comparator.reverseOrder());
        for(int i=0;i<N;i++) sb.append(arr[i]+"\n");
        System.out.println(sb);
    }
}
