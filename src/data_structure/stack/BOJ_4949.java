package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 한줄씩 입력받기
 * 2. )] 이 괄호가 먼저 보이면 바로 break
 * 3. ([ 이 괄호가 보이면 일단 push,
 * 4. () 나 [] 사이에 문자열에는 1-괄호가 없거나 2-여러개의 괄호가 쌍을 이루어야 -> 균형잡힌 문자열이 된다.
 *
 */

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            sb.append(answer(str)+'\n');
        }
        System.out.println(sb);
    }
    public static String answer(String line){
        char[] arr = line.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i:arr){
            if(i=='['||i=='(') stack.push((char) i);
            else if(i==']'){
                if(stack.isEmpty() || !stack.peek().equals('[')) {
                    stack.push(']');
                    break;
                } else stack.pop();
            }
            else if(i==')'){
                if(stack.isEmpty() || !stack.peek().equals('(')) {
                    stack.push(')');
                    break;
                } else stack.pop();
            }
        }
        if(stack.isEmpty()) return("yes");
        else return("no");
    }
}
