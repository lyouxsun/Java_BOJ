package MeasureMultipleDecimal_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MeasureSum_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringBuilder sb = new StringBuilder();
            int input = Integer.parseInt(br.readLine());
            if(input==-1) break;

            int[] arr = new int[input];
            int index = 0;
            int sum = 0;
            for(int i=1;i<input;i++){
                if(input%i==0) {
                    arr[index]=i;
                    sum+=i;
                    index++;
                }
            }
            if(sum==input){
                sb.append(input+" = ");
                for(int i=0;i<index;i++) {
                    sb.append(arr[i]);
                    if(i!=index-1) sb.append(" + ");
                }
                System.out.println(sb);
            } else System.out.println(input+" is NOT perfect.");
        }
    }
}
