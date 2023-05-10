package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumSum5_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int cnt = 1;  //자기자신 포함

        int[] sumArr = new int[input/2+2];

        for(int i=1;i<=input/2+1;i++) {
            sumArr[i]=sumArr[i-1]+i;
        }
        // left < right
        int left=1;
        int right=1;
        while(2<input && right<=input/2+1){
            int tmp = sumArr[right]-sumArr[left-1];
            if(tmp<input) {
                right++;
                continue;
            }
            else if(tmp>input) {
                left++;
                continue;
            }
            else {      //tmp==input
                cnt++;
                right++;
            }
            /**
             핵심은 n보다 커졌을 때 break를 하는 것과 안 하는 것의 차이입니다.
             수가 커지면 거의 대부분의 경우 n을 못 만드는데, 이럴 때마다 안쪽 루프가 끝까지 돌게 되느냐,
             아니면 이를 빠르게 감지하고 탈출하느냐에 따라 엄청난 시간 차이가 발생합니다.
             */
        }
        System.out.println(cnt);
    }
}
