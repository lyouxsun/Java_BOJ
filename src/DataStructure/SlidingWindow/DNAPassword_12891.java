package DataStructure.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNAPassword_12891 {
    static int[] cnt = new int[4];
    static int[] check = new int[4];

    public static void main(String[] args) throws IOException {
        //1. 문자열의 길이, 부분문자열의 길이 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st1.nextToken());
        int section = Integer.parseInt(st1.nextToken());
        int result=0;

        //2. 문자열 입력받기
        //- 반복문 안에서 arr배열에 (해당 차례의) 부분 문자열 넣어주기
        String str = br.readLine();
        char[] arr = str.toCharArray();

        //3. 부분문자열에서 A,C,G,T가 몇개 이상이어야 하는지 그 개수 순서대로 입력받기
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            check[i] = Integer.parseInt(st3.nextToken());
        }

        //첫번째 부분문자열만 조건을 만족하는지 확인하는 반복문
        int j=0;
        while(j<section){
            if(arr[j]=='A') cnt[0]++;
            else if(arr[j]=='C') cnt[1]++;
            else if(arr[j]=='G') cnt[2]++;
            else if(arr[j]=='T') cnt[3]++;
            j++;
        }
        if(cnt[0]>=check[0] && cnt[1]>=check[1] && cnt[2]>=check[2] && cnt[3]>=check[3]) result++;


        //Add, Remove 메서드 구현하기  -> 왜 메서드를 구현해야 할까

        for(int i=0;i<total-section;i++){ //생성될 수 있는 부분 문자열의 개수만큼 반복
            Remove(arr[i]);
            Add(arr[i+section]);
            if(cnt[0]>=check[0] && cnt[1]>=check[1] && cnt[2]>=check[2] && cnt[3]>=check[3]) result++;
        }

        //4. 출력 : 가능한 부분문자열의 개수 출력
        System.out.print(result);
    }

    //Add 메서드 구현
    private static void Add(char c) {
        switch(c){
            case 'A':
                cnt[0]++;
                break;
            case 'C':
                cnt[1]++;
                break;
            case 'G':
                cnt[2]++;
                break;
            case 'T':
                cnt[3]++;
                break;
        }
    }

    //Remove 메서드 구현
    private static void Remove(char c) {
        switch(c){
            case 'A':
                cnt[0]--;
                break;
            case 'C':
                cnt[1]--;
                break;
            case 'G':
                cnt[2]--;
                break;
            case 'T':
                cnt[3]--;
                break;
        }
    }
}