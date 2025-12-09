package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int i=1;
        while(input>i){
            input-=i;
            i++;
        }
        int tmp = i+1-input;
        if(i%2==0) System.out.println(input+"/"+tmp);
        else System.out.println(tmp+"/"+input);
    }
}
