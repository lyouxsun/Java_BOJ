package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/** 9
 * 1 2 3 4 5 6 7 8 9
 * 3456789 2
 * 56789 24
 * 789 246
 * 9 2468
 * 468 2
 * 8 26
 * 62
 * 2
 *
 * 1. Queue 생성, 1부터 N까지 차례대로 넣어주기
 * 2. queue.poll(), queue.add(queue.peek()), queue.poll() 반복
 * 3. while(queue.size>1)
 * 4. sout(queue.peek())
 */

public class Card2_2164 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) queue.add(i);
        for(int i=1;i<N;i++){
            queue.poll();
            queue.add(queue.peek());
            queue.poll();
        }
        System.out.println(queue.peek());
    }
}
