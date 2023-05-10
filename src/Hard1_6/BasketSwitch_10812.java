package Hard1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BasketSwitch_10812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int basket = Integer.parseInt(st.nextToken());;
        int cycle = Integer.parseInt(st.nextToken());;
        int[] basketArr = new int[basket+1];
        int[] tmpArr = new int[basket+1];

        //처음에 배열에 숫자 넣기
        for(int i=1;i<=basket;i++){
            basketArr[i] = i;
        }

        //바구니 바꾸기
        for(int i=0;i<cycle;i++){
            StringTokenizer str = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int mid = Integer.parseInt(str.nextToken());

            int tmp = first;

            //basketArr는 정답 배열이고, tmpArr는 숫자 옮길 때 사용할 배열
            for(int k=1;k<=basket;k++){
                tmpArr[k] = basketArr[k];
            }

            for(int j=mid;j<=end;j++){
                basketArr[tmp] = tmpArr[j];
                tmp++;
            }
            for(int j=first;j<mid;j++){
                basketArr[tmp] = tmpArr[j];
                tmp++;
            }
        }

        //바구니 속 숫자 출력
        for(int i=1;i<=basket;i++){
            System.out.print(basketArr[i]+" ");
        }
    }
}
