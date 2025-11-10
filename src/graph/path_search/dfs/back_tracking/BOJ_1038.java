package graph.path_search.dfs.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            return;
        }

        // 2. 해당 자리수에서 N번째로 감소하는 수 출력하기 (BruteForce로 하나씩)
        Set<Long> results = new TreeSet<>();
        createReduceNum(results);
        List<Long> resultList = new ArrayList<>(results);
        if (results.size() <= N) {
            System.out.println(-1);
            return;
        }
        long answer = resultList.get(N);
        System.out.println(answer);
    }

    private static void createReduceNum(Set<Long> results) {
        for (int i = 0; i < 10; i++) {
            back_tracking(i, results);
        }
    }

    // 자리수를 결정한 후에 감소하는 수 구하기 (X)
    // 모든 감소하는 수 구하기 (O) : 정지 조건 = 맨 뒷자리가 0인 경우 (더는 감소하는 수가 만들어질 수 없음)
    private static void back_tracking(long now, Set<Long> results) {
        if (now % 10 == 0) {
            results.add(now);
            return;
        }
        results.add(now);
        long last = now % 10L;
        now *= 10;
        for (long i = last - 1; i >= 0; i--) {
            back_tracking(now + i, results);
        }
    }

}
