package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//몇번의 루프만에 정렬이 됐는지 cnt하는 문제
public class BOJ_1377_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++) {
            arr[i][0]=Integer.parseInt(br.readLine());
            arr[i][1]=i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //for(int i=0;i<N;i++) System.out.println(arr[i][0]+" "+arr[i][1]+"\n");
        for(int i=0;i<N;i++) arr[i][1]-=i;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        //for(int i=0;i<N;i++) System.out.println(arr[i][0]+" "+arr[i][1]+"\n");
        System.out.println(arr[0][1]+1);
    }
}
