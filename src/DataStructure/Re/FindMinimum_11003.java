package DataStructure.Re;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FindMinimum_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque <Node> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        //1. 입력한 데이터 받기
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(st.nextToken());

            // 2. 뒤에서부터 비교 : 입력 데이터보다 더 크면 노드 삭제
            while (!deque.isEmpty() && deque.getLast().value >now) deque.removeLast();
            deque.addLast(new Node(now, i));

            //3. 슬라이딩 윈도우 처리 -> 앞의 노드 자르기
            if(deque.getFirst().index<=i-L) deque.removeFirst();

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;   //now
        public int index;   //i

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
