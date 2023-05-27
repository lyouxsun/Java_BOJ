package Geometry_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Site_9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] min = new int[2];     //인덱스==0 : x축 정보
        int[] max = new int[2];     //인덱스==1 : y축 정보
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if(i==0){
                min[0]=arr[i][0];
                min[1]=arr[i][1];
                max[0]=arr[i][0];
                max[1]=arr[i][1];
            }
            else{
                if(arr[i][0]<min[0]) min[0]=arr[i][0];
                else if(arr[i][0]>max[0]) max[0]=arr[i][0];
                if(arr[i][1]<min[1]) min[1]=arr[i][1];
                else if(arr[i][1]>max[1]) max[1]=arr[i][1];
            }
        }
        System.out.println((max[0]-min[0])*(max[1]-min[1]));
    }
}
