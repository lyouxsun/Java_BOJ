package DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                if (maxPQ.isEmpty()) sb.append("0\n");
                else {
                    sb.append(maxPQ.peek()+"\n");
                    maxPQ.remove();
                }
            } else {    //input!=0
                maxPQ.add(input);
            }
        }
        System.out.println(sb);
    }
}
