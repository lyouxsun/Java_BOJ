/*
package DataStructure.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//배열로 힙 구현하기
public class MinHeapImplement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //N:입력값 개수
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //1. 삽입 : 리프 노드에 삽입 -> 부모 노드와 비교 반복 (상향식)
        //2. 삭제 : 루트 노드 삭제 -> 리프 노드를 루트 노드로 가져오기 -> 자식 노드와 비교 (루트>자식 이면 둘 바꿔주기) 반복
        int leafIndex=1;   //리프 노드의 인덱스를 알려줌

        //1. 삽입
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            arr.add(leafIndex, input);
            while(arr.get(leafIndex) > arr.get(leafIndex / 2)) {
                    arr.set(leafIndex, arr.get(leafIndex / 2));
                    arr.set(leafIndex/2, input);
                }       //최소힙 구현
            leafIndex++;
            }

        //2. 삭제
        arr.remove(0);
        int tmp = arr.get(leafIndex)    //while문에서 arr.get(index)==tmp
        arr.set(0, tmp);
        arr.remove(leafIndex);
        int index=1;    //리프->루트노드가 된 수의 인덱스
        while(tmp>arr.get(2*index) || tmp>arr.get(2*index+1)){
            arr.set(index, arr.get(2*index));
            arr.set(2*index, tmp);
        }
    }
}

 */
