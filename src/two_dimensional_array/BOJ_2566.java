package two_dimensional_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max=0;
        int row = 1;
        int col = 1;


        //int[] maxCol = new int[9];    //배열의 인덱스를 저장
        int[] maxArr = new int[9];     //각 행에서의 최댓값을 저장
        //각 행에서의 최댓값을 maxArr에 저장 (9개의 수)
        for(int i=0;i<9;i++){       // i : 행을 의미
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {        // j : 열을 의미
                int tmp = Integer.parseInt(st.nextToken());
                if(max<tmp){
                    max= tmp;
                    row = i+1;
                    col = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(row+" "+col);
    }
}
