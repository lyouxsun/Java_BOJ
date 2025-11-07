package graph.pathSearch.dfs;

import java.util.HashMap;
import java.util.Map;

public class PG_단어변환 {
    int answer = Integer.MAX_VALUE;
    Map<String, Integer> minResult = new HashMap<>();

    public int solution(String begin, String target, String[] words) {
        boolean isExist = false;
        for (int i = 0; i < words.length; i++) {
            minResult.put(words[i], Integer.MAX_VALUE);
            if (words[i].equals(target)) {
                isExist = true;
            }
        }

        if (!isExist) {
            return 0;
        }

        dfs(begin, target, words, 0);
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    public void dfs(String now, String target, String[] words, int cnt) {
        if (now.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (onlyOne(now, words[i]) && minResult.get(words[i]) > cnt + 1) {
                minResult.put(words[i], cnt + 1);
                dfs(words[i], target, words, cnt + 1);
            }
        }
    }

    public boolean onlyOne(String now, String next) {

        int cnt = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != next.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return true;
        }
        return false;
    }
}
