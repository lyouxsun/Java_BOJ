package Sort_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//i= (처음인덱스-최종인데스)의 최댓값 +1
public class reBubbleSort_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][]arr = new int[input][2];
        for(int i=0;i<input;i++){
            arr[i][0]=Integer.parseInt(br.readLine());
            arr[i][1]=i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int max=0;
        for(int i=0;i<input;i++){
            if(max<arr[i][1]-i) max=arr[i][1]-i;
        }
        System.out.println(max+1);
    }
}
