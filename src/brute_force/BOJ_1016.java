package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_1016 {
    static long start;
    static long end;
    static Set<Long> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        start = Long.parseLong(line[0]);
        end = Long.parseLong(line[1]);
        result = new HashSet<>();

        for (long i = start ; i <= end ; i++) {
            result.add(i);
        }

        int x = 2;

        while (true) {
            long x2 = (long) Math.pow(x, 2);
            if (x2 > end) {
                break;
            }
            long i = (long) Math.max(1, Math.floor((double) start / x2));

            while (x2 * i <= end) {
                result.remove(x2 * i);
                i++;
            }

            x++;
        }

        System.out.println(result.size());
    }
}
