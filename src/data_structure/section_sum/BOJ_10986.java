package data_structure.section_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int division = Integer.parseInt(st.nextToken());
        long cnt = 0;
        long[] sumArr = new long[num];
        long[] cntArr = new long[division];      //sumArr%division의 값이 일치하는 경우의 개수를 cnt

        //합 배열 만들기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        sumArr[0] = Long.parseLong(st1.nextToken());
        for(int i=1;i<num;i++){     // i:몇개의 숫자를 더할지 나타냄
            sumArr[i] = sumArr[i-1] + Long.parseLong(st1.nextToken());
        }

        //나머지들의 합 배열 만들기
        for(int i=0;i<num;i++){     // i:몇개의 숫자를 더할지 나타냄
            sumArr[i] %= division;
            int remainder = (int) sumArr[i];
            cntArr[remainder]++;
        }

        //cnt
        //1. sumArr==0
        cnt+=cntArr[0];
        //2. sumArr의 값이 서로 같은
        for(int i=0;i<division;i++){
            cnt+=cntArr[i]*(cntArr[i]-1)/2;
        }
        System.out.println(cnt);
    }
}
