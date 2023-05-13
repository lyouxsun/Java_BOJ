package DataStructure.Re;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Good_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];
        int cnt = 0;

        //입력받은 수를 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int k=0;k<num;k++) {
            long goal = arr[k];
            int i = 0;
            int j = num - 1;

            //4
            //3 3 2 1
            //ㄹㅈㄷ반례
            //주의!!! : 정렬된 데이터에서 자기 자신을 좋은 수 만들기에 포함하면 안된다.
            while (i < j) {
                if (i==k) i++;
                else if (j==k) j--;

                else if(i!=k && j!=k) {
                    if (goal < arr[i] + arr[j]) {
                        j--;
                    } else if (goal > arr[i] + arr[j]) {
                        i++;
                    } else if (goal == arr[i] + arr[j]) {    //goal == arr[i] + arr[j]
                        cnt++;
                        break;
                    }
                }
            }
            System.out.println("k="+k+" goal="+goal+" i="+i+" j="+j+" cnt="+cnt);     //ㄹㅈㄷ확인문
        }
        System.out.println(cnt);
    }
}
