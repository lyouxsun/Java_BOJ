package data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int tmp;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++) queue.add(i);
        sb.append("<");
        while(!queue.isEmpty()){
            for(int i=0;i<K-1;i++){
                tmp = queue.poll();
                queue.add(tmp);
            }
            sb.append(queue.poll());
            if(queue.isEmpty()) sb.append(">");
            else sb.append(", ");
        }
        System.out.println(sb);
    }
}
