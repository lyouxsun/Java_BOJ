package DataStructure;

import java.io.*;
import java.util.Stack;

public class StackNumArray_1874 {
    public static void main(String[] args) throws IOException {
        //1. N, N개의 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int tmp=0;

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]==N) tmp=i;
        }

        //3. 아니라면 stack 연산 수행
        Stack<Integer> stack = new Stack<>();

        //3-1. arr[0]만큼 push & pop한번
        for(int i=0;i<arr[0];i++){
            stack.push(i+1);
            sb.append("+\n");
        }

        stack.pop();
        sb.append("-\n");
        int next=arr[0]+1;

        //3-2. arr[1] ~ arr[N-1]
        for(int i=1;i<N;i++) {

            //2. 불가능한 수열 처리
            if ((arr[i] < next && arr[i] != stack.peek()) || (arr[i]<next && stack.isEmpty())) {
                System.out.print("NO");
                return;
            }
            if (!stack.isEmpty()&&arr[i]==stack.peek()) {
                stack.pop();
                sb.append("-");
                if(i!=N-1) sb.append("\n");
                continue;
            }
            if (arr[i] >= next) {
                while(next<=arr[i]){
                    stack.push(next);
                    sb.append("+\n");
                    next++;
                }
                stack.pop();
                sb.append("-");
                if(i!=N-1) sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
