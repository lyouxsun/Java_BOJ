package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1035 {
    static int K = 0;
    static Queue<Result> q = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Set<Long> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> pos = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (line.charAt(j) == '*') {
                    pos.add(i * 5 + j);
                }
            }
        }
        K = pos.size();

        if (K == 1) {
            System.out.println(0);
            return;
        }
        q.add(new Result(0, pos));
        visited.add(encode(pos));

        while (!q.isEmpty()) {
            Result result = q.poll();
            int moveNum = result.count;
            Set<Integer> position = result.pos;
//            printPosition(position, moveNum);

            if (union(position)) {
                System.out.println(moveNum);
                return;
            }

            // 모든 조각들을 한칸씩 이동시키기
            List<Integer> posList = new ArrayList<>(position);

            for (int i = 0; i < K; i++) {
                for (int j = 0; j < 4; j++) {
                    int cur = posList.get(i);
                    int cy = cur / 5;
                    int cx = cur % 5;

                    int ny = cy + dy[j];       // 행
                    int nx = cx + dx[j];       // 열

                    if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                        // 큐에 다시 넣기 (맨 뒤에는 이동 횟수 추가)
                        Set<Integer> np = new HashSet<>();
                        for (int k = 0; k < K; k++) {
                            if (k == i) {
                                np.add(ny * 5 + nx);
                            } else {
                                np.add(posList.get(k));
                            }
                        }

                        // 조각의 위치가 겹치면 이동 불가
                        if (np.size() == K) {
                            // visited 로 중복 상태 제거
                            long key = encode(np);
                            if (visited.add(key)) {
                                q.add(new Result(moveNum + 1, np));
                            }
                        }
                    }
                }
            }

        }


    }

    // visited용 상태 인코딩: Set<Integer> => 정렬 후 5비트씩 long에 pack
    private static Long encode(Set<Integer> tmp) {
        int[] a = new int[K];
        int idx = 0;
        for (int v : tmp) a[idx++] = v;
        Arrays.sort(a);

        long key = 0L;
        for (int i = 0; i < K; i++) {
            key |= ((long) a[i]) << (5 * i);        // 0~24 => 5비트
        }
        return key;
    }

    private static void printPosition(Set<Integer> position, int moveNum) {
        System.out.print("조각들 위치 = ");
        for (Integer i : position) {
            System.out.print(i + ", ");
        }

        System.out.print(" / 움직인 횟수 총합 = " + moveNum + "\n");
    }

    // 모든 조각들이 연속되어 있으면 true, 아니면 false를 반환한다.
    private static boolean union(Set<Integer> tmpPos) {
        int[][] arr = new int[5][5];
        int[][] v = new int[5][5];

        List<Integer> pos = new ArrayList<>(tmpPos);
        for (int p : pos) {
            arr[p / 5][p % 5] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int start = pos.get(0);
        int cnt = 1;
        q.add(start);
        v[start / 5][start % 5] = 1;

        while (!q.isEmpty()) {
            Integer p = q.poll();
            int y = p / 5;
            int x = p % 5;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];       // 행
                int nx = x + dx[i];       // 열
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && arr[ny][nx] == 1 && v[ny][nx] == 0) {
                    v[ny][nx] = 1;
                    q.add(ny * 5 + nx);
                    cnt++;
                }
            }
        }
        return cnt == K;
    }

    static class Result {
        public int count;
        public Set<Integer> pos;

        public Result(int count, Set<Integer> pos) {
            this.count = count;
            this.pos = pos;
        }
    }

}
