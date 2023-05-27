import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 1. 최소힙 만들기 (배열 이용)
 * 2. 음수->tmp=-1*input , 양수->tmp=inpput 으로
 *    tmp값에 따라 Heap에 input값을 그대로 저장
 * 3. input의 절댓값이 같을 때 설정해주기
 *    -> 둘중에 input값이 더 작은걸 왼쪽에 저장 (나중에 왼쪽부터 출력)
 *    -> 그럼 |input|으로 첫번째 정렬하고
 *    -> input으로 세부정렬ㄱ
 * 4. 출력
 *    - 만약 힙이 비었으면 0출력
 *    - 아니라면 루트노드 출력 후 제거
 */
public class AbsoluteValueHeap_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absPQ = new PriorityQueue<>();
        //큐에다가 (배열의 인덱스, 절댓값)로 구성된 노드를 저장, 큐의 우선순위는 절댓값에 따라 결정됨
        //만약 같은 수가 여러개일 때에는 arr[인덱스]로 가서 확인 -> 음수가 있으면 음수 개수만큼 먼저 출력
        

    }
}
