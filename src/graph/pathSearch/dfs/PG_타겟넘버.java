package graph.pathSearch.dfs;

public class PG_타겟넘버 {
    int answer = 0;
    int size, t;
    public int solution(int[] numbers, int target) {
        size = numbers.length;
        t = target;

        dfs(numbers, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int idx, int result) {
        if (idx == size) {
            if (result == t) {
                answer++;
            }
            return;
        }

        dfs(numbers, idx+1, result + numbers[idx]);
        dfs(numbers, idx+1, result - numbers[idx]);

    }
}


// import java.lang.Math.*;
//
//class Solution {
//    public int solution(int[] numbers, int target) {
//
//        // 그래프 생성 : by 배열
//        int len = numbers.length;
//        int size = (int) Math.pow(2, (len+1));
//        // System.out.print("size =" + size);
//        int[] results = new int[size];
//
//
//
//
//        // 계산 시작
//        for (int i = 1; i <= len ; i++) {
//
//            int n = numbers[i-1];
//
//            for(int j = (int) Math.pow(2, i); j < (int) Math.pow(2,(i+1)) ; j++) {
//                if (j % 2 == 0) {
//                    results[j] = results[j/2] - n;
//                } else {
//                    results[j] = results[j/2] + n;
//                }
//            }
//
//        }
//
//
//        // 결과 확인
//        int answer = 0;
//        int start = (int) Math.pow(2, len);
//        int end = (int) Math.pow(2, (len+1));
//
//
//        for (int i = start; i < end; i++) {
//            // System.out.print(results[i] + ", ");
//            if (results[i] == target) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//}