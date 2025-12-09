package data_structure.stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            Stack<Character> stack = new Stack<>();
            String input = sc.next();
            int length = input.length();
            for(int j=0;j<length;j++){
                if(stack.isEmpty() && input.charAt(j)==')') {
                    stack.push('a');
                    break;
                }
                else if(input.charAt(j)=='(') stack.push('(');
                else if(!stack.isEmpty() && input.charAt(j)==')') stack.pop();
                if(j==length-1 && stack.isEmpty()) System.out.println("YES");
            }
            if(!stack.isEmpty()) System.out.println("NO");
        }
    }
}
