import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BalanceWorld_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ".");
        String line = st.nextToken();

        while(true){
            if(line.equals(".")) {
                System.out.println("yes");
                break;
            }
            Stack<Character> stack1 = new Stack<>();    //[]
            Stack<Character> stack2 = new Stack<>();    //{}
            Stack<Character> stack3 = new Stack<>();    //()

            for(int i=0;i<line.length();i++){
                if(line.charAt(i)=='[') stack1.push('[');
                else if(line.charAt(i)==']'){
                    if(stack1.isEmpty()) {
                        System.out.println("no");
                        break;
                    }
                    else stack1.pop();
                }

                else if(line.charAt(i)=='{') stack2.push('{');
                else if(line.charAt(i)=='}'){
                    if(stack2.isEmpty()) {
                        System.out.println("no");
                        break;
                    }
                    else stack2.pop();
                }

                else if(line.charAt(i)=='(') stack3.push('(');
                else if(line.charAt(i)==')'){
                    if(stack3.isEmpty()) {
                        System.out.println("no");
                        break;
                    }
                    else stack3.pop();
                }

            }
            if(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty()) System.out.println("yes");
        }
    }
}
