package MeasureMultipleDecimal2_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 input을 받음
 * 둘 중 더 큰 수가 n이라 하면 -> n+1크기의 배열 만들기
 * 둘의 약수 구하기 -> arr[약수]=1해주기
 * if(arr[i]=1) mutiple*=i
 * sout(mutiple)
 */
public class LCM_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==1||b==1) System.out.println(a*b);
            else if(a==b) System.out.println(a);
            else{
                int small;
                if(a>b) small=b;
                else small=a;

                int tmp=a*b;
                int cnt=2;
                while(cnt<=small && a>1 && b>1){
                    if(a%cnt==0 && b%cnt==0) {
                        tmp/=cnt;
                        a/=cnt;
                        b/=cnt;
                        continue;
                    }
                    cnt++;
                }
                System.out.println(tmp);
            }
        }
    }
}
