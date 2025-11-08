package DP;

import java.util.*;

class PG_N으로표현 {
    public int solution(int N, int number) {
        // 1. N == number인 경우 먼저 고려
        if (N == number) {
            return 1;
        }

        // 2. N을 i번 썼을 때 만들 수 있는 모든 수를 Set에 저장
        List<Set<Integer>> results = new LinkedList<>();
        for (int i = 0; i <= 8; i++) {
            results.add(new HashSet<>());
        }

        // 3. N을 1번 사용할 때 ~ 8번 사용할 때 만들 수 있는 수 저장
        for (int cnt = 1; cnt <= 8; cnt++) {
            // 4-1. 이어붙이는 방식 먼저 고려 (만약 이 수가 number라면 여기서 종료)
            int joined  = N;
            for (int i = 1; i < cnt; i++) {
                joined = joined * 10 + N;
            }
            results.get(cnt).add(joined);
            if (joined == number) {
                return cnt;
            }

            // 4-2. N을 1개 ~ (cnt-1)개 사용했을 때의 수와 사칙연산

            for (int k = 1; k <= cnt; k++) {
                if (cnt - k <= 0) {
                    continue;
                }
                List<Integer> iResults = new ArrayList<>(results.get(k));
                List<Integer> jResults = new ArrayList<>(results.get(cnt-k));

                for (Integer i:iResults) {
                    for (Integer j:jResults) {
                        results.get(cnt).add(i+j);
                        results.get(cnt).add(i-j);
                        results.get(cnt).add(i*j);
                        if (j != 0) {
                            results.get(cnt).add(i/j);
                        }
                    }
                }

            }

            // 4-3. 이 set에 number가 있는지 확인
            if (results.get(cnt).contains(number)) {
                return cnt;
            }

        }
        return -1;
    }
}