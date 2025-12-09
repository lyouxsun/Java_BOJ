package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum=0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0) stack.pop();
            else stack.push(input);
        }
        if(!stack.empty()) {
            int tmp=stack.size();
            for (int i = 0; i < tmp; i++) {     //tmp자리에 stack.size()를 그대로 써버리면 반복문이 한번 돌 때마다 stack.size()도 같이 줄어든다.
                    sum += stack.peek();
                    stack.pop();
            }
        }
        System.out.println(sum);
    }
}
