package sw;

import java.util.Scanner;
import java.io.FileInputStream;
class Solution2
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T, num;
        long sum;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sum = 0;
            num = sc.nextInt();
            long[][] arr = new long[num][3];
            long[] max = new long[3];
            long[] maxInLine = new long[num];

            if(num < 3){
                System.out.println("#"+test_case+" -1");
                continue;
            }
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextLong();
                    sum += arr[i][j];

                    if(arr[i][j] > maxInLine[j]) {
                        maxInLine[i] = arr[i][j];
                        if(arr[i][j] > max[j]){
                            max[j] = arr[i][j];
                        }
                    }
                }
                sum -= maxInLine[i];
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}
