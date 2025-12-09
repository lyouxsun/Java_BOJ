package data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 배열(ArrayList)로 최소 힙 구현하기
public class min_heap_implement {

    // 1번 인덱스부터 사용하는 최소 힙
    private static final ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 연산 개수

        // 0번 인덱스는 사용하지 않으므로 더미 값 하나 추가
        heap.add(0);

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 최소값 출력 후 제거 (없으면 0 출력)
                sb.append(pop()).append('\n');
            } else {
                // 힙에 값 삽입
                push(x);
            }
        }

        System.out.print(sb);
    }

    // 최소 힙에 원소 삽입 (상향식 heapify-up)
    private static void push(int x) {
        heap.add(x);                     // 마지막(리프)에 삽입
        int idx = heap.size() - 1;       // 현재 노드 인덱스

        // 부모와 비교하면서 위로 올리기 (부모가 더 크면 교환)
        while (idx > 1) {                // 루트(1번)보다 아래에 있을 때만
            int parent = idx / 2;
            if (heap.get(parent) <= heap.get(idx)) {
                break;                   // 이미 최소 힙 조건 만족
            }
            swap(parent, idx);
            idx = parent;
        }
    }

    // 최소값 제거 후 반환 (하향식 heapify-down)
    private static int pop() {
        if (heap.size() == 1) {
            // 힙이 비어 있는 경우 (더미만 있는 상태)
            return 0;
        }

        int minValue = heap.get(1);                        // 루트 값(최소값)
        int lastValue = heap.remove(heap.size() - 1);      // 마지막 리프 값 제거 후 저장

        if (heap.size() == 1) {
            // 루트 하나만 있었던 경우
            return minValue;
        }

        heap.set(1, lastValue);                            // 마지막 값을 루트로 올림
        int idx = 1;

        // 자식과 비교하면서 아래로 내려보내기
        while (true) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int smallest = idx;

            // 왼쪽 자식이 존재하고 더 작다면
            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            // 오른쪽 자식이 존재하고 더 작다면
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == idx) {
                // 자신이 가장 작으면 종료 (힙 조건 만족)
                break;
            }

            swap(idx, smallest);
            idx = smallest;
        }

        return minValue;
    }

    // ArrayList 내에서 두 인덱스의 값 교환
    private static void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
