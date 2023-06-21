package Sort_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        int sum=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[people];
        for(int i=0;i<people;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<people;i++){
            int tmp = people-i;
            sum+=tmp*arr[i];
        }
        System.out.println(sum);
    }
}
