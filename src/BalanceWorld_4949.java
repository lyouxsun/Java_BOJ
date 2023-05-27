import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BalanceWorld_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.nextToken()!="."){
            String line = st.nextToken();
            Stack<Character> stack1 = new Stack<>();    //[]
            Stack<Character> stack2 = new Stack<>();    //{}
            Stack<Character> stack3 = new Stack<>();    //()

            for(int i=0;i<line.length();i++){

                if((stack1.isEmpty() && line.charAt(i)==']') || (stack1.isEmpty() &&line.charAt(i)=='}') || (stack1.isEmpty() &&line.charAt(i)==')')) {
                    System.out.println("NO");
                    break;
                }
                if (line.charAt(i) == ']') stack1.pop();
                else if (line.charAt(i) == '}') stack2.pop();
                else if (line.charAt(i) == ')') stack3.pop();

                else {
                    if (line.charAt(i) == '[') stack1.push('[');
                    else if (line.charAt(i) == '{') stack2.push('{');
                    else if (line.charAt(i) == '(') stack3.push('(');

                    /*
                    if (!stack1.isEmpty() && line.charAt(i) == ']') stack1.pop();
                    else if (!stack2.isEmpty() && line.charAt(i) == '}') stack2.pop();
                    else if (!stack3.isEmpty() && line.charAt(i) == ')') stack3.pop();
                    */
                }
                if(i == line.length() - 1){
                    if (stack1.isEmpty() && stack2.empty() && stack1.isEmpty()) {
                        System.out.println("YES");
                        break;
                    }
                    else System.out.println("NO");
                }
            }
        }
    }
}
