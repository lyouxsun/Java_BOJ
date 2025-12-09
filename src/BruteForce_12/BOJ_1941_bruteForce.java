package BruteForce_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BOJ_1941_bruteForce {
    static int[][] seat = new int[5][5];
    static int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static Set<Set<Point>> answers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                if (line[j].contains("S")) {
                    seat[i][j] = 1;
                }
            }
        }

        // 2. 25개의 2차원 좌표에서 인접한 7개의 좌표 구하기
        Set<Point> results = new HashSet<>();
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                results.add(new Point(y, x));
                combination(results);
                results.remove(new Point(y, x));
            }
        }
        System.out.println(answers.size());
    }

    private static void combination(Set<Point> results) {
//        System.out.println("results 사이즈 = " + results.size());
        if (results.size() == 7) {
            // 이 조합에서 다솜이파가 4명 이상인지 확인 후 반환
            if (dasomSum(results) >= 4) {
//                printSeats(results);
//                answers.add(results);         // 아니 이거하나 다르다고 틀린다고?!?!?!

                answers.add(new HashSet<>(results));

                return;
            }
            return;
        }

        // 다음칸으로~
//        for (int i = 0; i < 4; i++) {
//            int ny = y + direction[i][0];
//            int nx = x + direction[i][1];
//            if (0 <= ny && ny < 5 && 0 <= nx && nx < 5 && !results.contains(new Point(ny, nx))) {
//                results.add(new Point(ny, nx));
//                combination(results, ny, nx);
//                results.remove(new Point(ny, nx));
//            }
//        }
        for (Point result : new HashSet<>(results)) {
            for (int i = 0; i < 4; i++) {
                int ny = result.y + direction[i][0];
                int nx = result.x + direction[i][1];
                Point next = new Point(ny, nx);

                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5 && !results.contains(next)) {
                    results.add(next);
                    combination(results);
                    results.remove(next);
                }
            }
        }
    }

    private static void printSeats(Set<Point> v) {
        for (Point p : v) {
            System.out.println(p.y + "행 " + p.x + "열");
        }
        System.out.println();
    }

    private static int dasomSum(Set<Point> seats) {
        int num = 0;
        for (Point s : seats) {
            num += seat[s.y][s.x];
        }
        return num;
    }

    public static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}