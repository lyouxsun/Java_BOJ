package String_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5052 {
    static Map<Integer, List<String>> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            cycle(br);
        }
    }

    private static void cycle(BufferedReader br) throws IOException {
        numbers = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine().trim();
            int start = Integer.parseInt(String.valueOf(str.charAt(0)));
            numbers.computeIfAbsent(start, k -> new ArrayList<>());
            numbers.get(start).add(str);
        }

        for (List<String> value : numbers.values()) {
            Collections.sort(value);
            for (int i = 0; i < value.size() - 1; i++) {
                String str1 = value.get(i);
                for (int j = i + 1; j < value.size(); j++) {
                    String str2 = value.get(j);

                    String s = str1;
                    String l = str2;
                    if (str1.length() > str2.length()) {
                        s = str2;
                        l = str1;
                    }
                    if (l.startsWith(s)) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
