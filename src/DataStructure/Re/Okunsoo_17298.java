package DataStructure.Re;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Okunsoo_17298 {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 입력값을 입력받아서 배열에 순서대로 넣음
         * 2. 스택에다 배열의 인덱스를 0~N-1 까지 넣음.
         *    인덱스를 넣을 때, arr[peek]<arr[스택에들어가는(인덱스)수] 이면 arr[스택수]는 arr[peek]의 오큰수가 된다 -> pop[peek] -> push[스택수]
         * 3. 마지막에 스택에 비어있는 수들을 x라 하면 arr[x]=-1 로 채워주기
         */
        //1.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());

        //2.
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            if(arr[stack.peek()]>arr[i]){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                answer[stack.peek()]=arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        for(int i=0;i<N;i++){
            if(answer[i]==0) answer[i]=-1;
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}
