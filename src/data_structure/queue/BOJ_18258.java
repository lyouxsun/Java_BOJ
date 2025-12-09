package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int back=0;
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("push")) {
                back = Integer.parseInt(st.nextToken());
                queue.add(back);
            }
            else if(input.equals("pop")){
                if(!queue.isEmpty()) sb.append(queue.poll()+"\n");
                else sb.append("-1\n");
            }
            else if(input.equals("size")) sb.append(queue.size()+"\n");

            else if(input.equals("empty")){
                if(queue.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(input.equals("front")){
                if(!queue.isEmpty()) sb.append(queue.peek()+"\n");
                else sb.append("-1\n");
            }
            else if(input.equals("back")){
                if(!queue.isEmpty()) sb.append(back+"\n");
                else sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
}
