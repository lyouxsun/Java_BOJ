package sw;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1
{
    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T, tmp, min, max;
        T=sc.nextInt();
		// 삼각형 그래프 만들기
        int[][] dp = new int[141][141];


        for(int test_case = 1; test_case <= T; test_case++)
        {
            min = sc.nextInt();
            max = sc.nextInt();
            if(min > max){
                tmp = min;
                min = max;
                max = tmp;
            }


            System.out.print("#"+test_case+" ");
            int ans = 0;

            /**
             * 최단거리 -> BFS (큐에 방문 가능한 모든 노드를 집어넣기
             *        -> 큐에 있는 모든 노드가 접근 가능한 노드를 다시 넣음
             *        -> 방문한 노드에는 몇번만에 왔는지 최단경로를 저장)
             */
            // 왼쪽 아래 : +자기 층수, 오른쪽 아래 : +자기 층수+1
            System.out.println(ans);
        }
    }
}
