import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 1. 최소힙 만들기 (배열 이용)
 * 2. 음수->tmp=-1*input , 양수->tmp=input 으로
 *    tmp값에 따라 Heap에 input값을 그대로 저장
 * 3. input의 절댓값이 같을 때 설정해주기
 *    -> 둘중에 input값이 더 작은걸 왼쪽에 저장 (나중에 왼쪽부터 출력)
 *    -> 그럼 |input|으로 첫번째 정렬하고
 *    -> input으로 세부정렬ㄱ
 * 4. 출력
 *    - 만약 힙이 비었으면 0출력
 *    - 아니라면 루트노드 출력 후 제거
 */

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
