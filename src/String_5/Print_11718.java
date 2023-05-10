package String_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(str!=null){
            System.out.println(str);
            str=br.readLine();
        }
    }
}
