package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Equilateral :  세 변의 길이가 모두 같은 경우
 * Isosceles : 두 변의 길이만 같은 경우
 * Scalene : 세 변의 길이가 모두 다른 경우
 * Invalid : 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다.
 *           가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
 */
public class BOJ_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr=new int[3];
        while(true){
            int max = 0;
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<3;i++) {
                arr[i]=Integer.parseInt(st.nextToken());
                sum+=arr[i];
                if(arr[i]>max) max = i;
            }
            if(arr[0]==0 && arr[1]==0 && arr[2]==0) break;
            else if(arr[max]>=sum-arr[max]) System.out.println("Invalid");
            else{
                if(arr[0]==arr[1] && arr[1]==arr[2]) System.out.println("Equilateral");
                else if(arr[0]==arr[1] || arr[1]==arr[2] || arr[0]==arr[2]) System.out.println("Isosceles");
                else System.out.println("Scalene");
            }
        }
    }
}
