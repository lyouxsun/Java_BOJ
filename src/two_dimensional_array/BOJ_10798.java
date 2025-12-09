package two_dimensional_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        int[] length = new int[5];

        for(int i=0;i<5;i++){
            //StringTokenizer st = new StringTokenizer(br.readLine());
            String str = br.readLine();
            length[i]=str.length();
            for(int j=0;j<str.length();j++) arr[i][j] = str.charAt(j);

        }
        /*
        for(int i=0;i<5;i++){
            for(int j=0;j<length[i];j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        */


        StringBuilder sb = new StringBuilder();

        for(int j=0;j<15;j++){
            for(int i=0;i<5;i++) {
                if(arr[i][j] == '\0') continue;
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);

    }
}