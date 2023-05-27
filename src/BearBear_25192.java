/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 처음엔 무조건 ENTER
 * 그 이후에 처음 나오는 문자열(이름)이 등장하면 cnt
 * 2번 이상 나온 거라면 cnt(X)

public class BearBear_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N-1;
        String[] str = new String[N];
        br.readLine();  //처음엔 무조건 ENTER

        for(int i=0;i<N-1;i++){
            str[i]=br.readLine();
            if(str[i].equals("ENTER")){
                cn20t--;
                str = new String[N];//str초기화
                continue;
            }
            for(int j=0;j<i;j++){
                if(str[i].equals(str[j])) {
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
*/