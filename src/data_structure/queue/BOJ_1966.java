package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문서 개수, 내가 알고싶은 문서의 인덱스
 * 각 문서들의 중요도
 * -> 애초에 중요도 높은 순서대로 인덱스를 넢기!
 *   내가 찾고자하는 인덱스와 pop()이 같다면 반복문 break, sb.append(cnt)
 *
 * 순서도가 높은 순으로 출력
 * 노드에 중요도 저장, cnt셌다가
 * 배열에 저장
 */
public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cycle;i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<N;j++){
                if(arr[target]<arr[j]) cnt++;
                else if(arr[target]==arr[j]){
                    if(target>j) cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
