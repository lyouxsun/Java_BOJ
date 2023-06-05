package Sort_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AgeSort_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr=new String[N][3];
        int[][] arrInt=new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=st.nextToken();
            arr[i][1]=String.valueOf(i);
            arr[i][2]=st.nextToken();
            arrInt[i][0]=Integer.parseInt(arr[i][0]);
            arrInt[i][1]=Integer.parseInt(arr[i][1]);
        }
        Arrays.sort(arrInt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i=0;i<N;i++) System.out.println(arrInt[i][0]/*+" "+arrInt[i][1]*/+" "+arr[arrInt[i][1]][2]);
    }
}
