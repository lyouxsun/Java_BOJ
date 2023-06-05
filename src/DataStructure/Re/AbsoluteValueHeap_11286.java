package DataStructure.Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 우선순위 큐 사용
 *  - 절댓값을 기준으로 우선순위큐 안에 정렬
 *  - 만약 절댓값이 같다면 음수먼저 정렬 -> 이걸 어떻게 하는거지..
 *  - 정렬기준을 새로 적용하여 선언하는 방법 익히기!!!
 */
public class AbsoluteValueHeap_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absPQ = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs==second_abs)
                return o1>o2?1:-1;      //절댓값이 같을 때 -> 음수 먼저 정렬
            else
                return first_abs - second_abs;//절댓값이 다를 때 -> 절댓값을 기준으로 정렬
                //first_abs > second_abs : 양수 리턴 -> 자리 바꿈
                //first_abs < second_abs : 음수 리턴 -> 자리 유지
        });

        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                if(absPQ.isEmpty()) sb.append("0\n");
                else sb.append(absPQ.remove()+"\n");
            }
            else absPQ.add(input);
        }
        System.out.println(sb);
    }
}
