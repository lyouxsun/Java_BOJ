package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindMinimum_NoDeque_11003 {

    static int L;
    static int[] A;
    static int[] minimum;
    public static void main(String[] args) throws IOException {
        //1. 입력 받아주기 (N, L, N개의 A는 배열에 넣기 + min저장하는 배열 min 만들기)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        L = Integer.parseInt(st1.nextToken());
        minimum = new int[N];
        A = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st2.nextToken());

        //2. for(i:1~N)에서 각 구간의 최솟값을 구하고, D에 넣어주기
        // 슬라이딩 윈도우 사용해주기 -> 처음 min=A[0]
        // -> remove : 삭제되는 원소==min일 때에만 최솟값을 다시 구한다. -> return값 없이 minimum[i]을 바꿔줌
        // -> add : min과 새로 추가되는 원소 이렇게만 대소비교 하면 된다. -> return 새로운 최솟값
        minimum[0] = A[0];
        int tmp;

        for(int i=1;i<N;i++){
            if(i<L){   //Add만 해주기
                FirstAdd(i);
            }

            else {
                tmp = Remove(i);
                Add(i,tmp);
            }
        }

        //3. for 문 사용해서 D 출력하기
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) sb.append(minimum[i]+" ");
        System.out.println(sb);
    }

    private static void FirstAdd(int i) {
        if(A[i]<minimum[i-1]) minimum[i]=A[i];
        else minimum[i]=minimum[i-1];
    }

    //A[i] 삭제할 때 사용
    public static int Remove(int i){
        if(A[i-L]==minimum[i-1]){      //삭제하는 원소가 min일 때
            if(A[i-L+1]<A[i-L+2]) return A[i-L+1];
            else return A[i-L+2];
        }
        else return minimum[i-1];
    }
    public static void Add(int i, int tmp){
        if(A[i]<tmp) minimum[i]=A[i];
        else minimum[i]=tmp;
    }
}
/**
 * 문제 이해하기
 * N : 수의 개수
 * L : 슬라이딩 윈도우를 할 때 한 윈도우 속 성분의 개수
 * D(i) = A(i-L+1) ~ A(i) -> (i=1;i<=N;i++)
 * N=12, L=3일 때,
 * D(1) = A(1-3+1) ~ A(1)   //-1~1
 * D(2) = A(2-3+1) ~ A(2)   //0~2
 * D(3) = A(3-3+1) ~ A(3)   //1~3       i가 3일 때부터 remove,
 * D(4) = A(4-3+1) ~ A(4)   //2~4
 */
