package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[3][2];
        int answer=0;

        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<2;i++) {
            if (arr[0][i] == arr[1][i]) answer = arr[2][i];
            else {
                if (arr[0][i] == arr[2][i]) answer = arr[1][i];
                else answer = arr[0][i];
            }
            sb.append(answer+" ");
        }
        System.out.println(sb);
    }
}
