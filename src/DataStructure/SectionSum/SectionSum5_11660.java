package DataStructure.SectionSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SectionSum5_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cycle = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        long[][] sumArr = new long[N+1][N+1];

        //원래 배열 만들기
        for(int i=1;i<=N;i++){      //행
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){      //열
                arr[i][j]=Integer.parseInt(st1.nextToken());
            }
        }

        //구간합 배열 만들기
        for(int i=1;i<=N;i++){       //행
            for(int j=1;j<=N;j++){      //열
                sumArr[i][j]=sumArr[i-1][j]+sumArr[i][j-1]-sumArr[i-1][j-1]+arr[i][j];

            }
        }

        for(int i=0;i<cycle;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int y1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());
            System.out.println(sumArr[x2][y2] - sumArr[x2][y1-1] - sumArr[x1-1][y2] + sumArr[x1-1][y1-1]);
        }
    }
}
