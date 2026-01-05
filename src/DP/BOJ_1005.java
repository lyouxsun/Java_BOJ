package dp;

import java.io.*;
import java.util.*;

/**
 * 위상정렬 + DP
 */
public class BOJ_1005 {

    static int T, N, K, W;
    static long[] dur, dp, indegree;
    static int[][] rules;
    static List<List<Integer>> topol;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 1. 입력 받기
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            K = Integer.parseInt(line[1]);

            dur = new long[N + 1];
            dp = new long[N + 1];
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                dur[j + 1] = Integer.parseInt(line[j]);
                dp[j + 1] = dur[j + 1];
            }

            rules = new int[K][2];
            for (int j = 0; j < K; j++) {
                line = br.readLine().split(" ");
                rules[j][0] = Integer.parseInt(line[0]);
                rules[j][1] = Integer.parseInt(line[1]);
            }
            W = Integer.parseInt(br.readLine());

            // 2. 위상정렬을 하면서 DP를 같이 계산
            // 위상정렬로 건물 지을 순서를 정하고 -> dp[i]에 i번째 건물을 다 짓는데 걸리는 시간 계산하기
            // 2-1. indegree 계산하기
            topol = new ArrayList<>();
            indegree = new long[N + 1];

            for (int j = 0; j <= N; j++) {
                topol.add(new ArrayList<>());
            }

            for (int j = 0; j < K; j++) {
                topol.get(rules[j][1]).add(rules[j][0]);
                indegree[rules[j][1]]++;
            }

            // 2-2. indegree가 0인 애들 큐에 넣기
            q.clear();
            for (int j = 1; j <= N; j++) {
                if (indegree[j] == 0) {
                    q.add(j);
                }
            }

            // 2-3. q에서 값을 하나씩 꺼내서 최소 시간 계산하기
            // 3. dp 테이블 채우기 : dp[i] = i번째 건물을 다 짓는데 걸리는 최소 시간
            while (!q.isEmpty()) {
                Integer now = q.poll();

                // 1 - 일단 dp[now] 계산하기
                long max_before = 0;
                for (Integer before : topol.get(now)) {
                    max_before = Math.max(max_before, dp[before]);
                }
                dp[now] += max_before;

                // 2 - now를 선수 조건이라고 둔 노드들에 대해서 indegree--;
                int next;
                for (int j = 0; j < K; j++) {
                    if (rules[j][0] == now) {
                        next = rules[j][1];
                        indegree[next]--;
                        // 3 - 그렇게 해서 indegree가 0이 된 애들이 있으면 q에 집어넣기
                        if (indegree[next] == 0) {
                            q.add(next);
                        }
                    }
                }
            }
            System.out.println(dp[W]);
        }
    }
}
