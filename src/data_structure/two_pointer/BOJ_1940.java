package data_structure.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int materialNum = Integer.parseInt(br.readLine());
        int goal = Integer.parseInt(br.readLine());
        int[] material = new int[materialNum];
        int cnt=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<materialNum;i++){
            material[i]=Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(material);

        /**투포인터 -> left right
         * if(left+right<goal) left++;
         * else if(left+right>goal) right--;
         * else if(left+right==goal) cnt++; left++; right--;
         */

        int left=0;
        int right=materialNum-1;

        while(true){
            if(left>=right) break;
            if(material[left]+material[right]<goal) {
                left++;
            }
            else if(material[left]+material[right]>goal){
                right--;
            }
            else {//if(material[left]+material[right]==goal)
                cnt++;
                left++;
                right--;
            }
        }
        System.out.println(cnt);
    }
}
