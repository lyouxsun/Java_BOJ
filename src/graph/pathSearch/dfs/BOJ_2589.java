package graph.pathSearch.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Math.max;


// bfs + BRUTE FORCE
// 한 섬에 대해서 한번만 bfs 하지 X
// 모든 육지 점에 대해서 bfs를 수행한다.
public class BOJ_2589 {
    static int W;
    static int H;
    static int[][] graph;
    static int[][] visited;
    static int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        graph = new int[H][W];
        visited = new int[H][W];


        // 1. 그래프 입력받기 (문자 -> 숫자 0/1로)
        for (int i = 0; i < H; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < W; j++) {
                if (line[j].equals("L")) {
                    graph[i][j] = 1;
                }
            }
        }

        // 2. ~~그래프 새로운 그룹 찾아서 -> 해당 섬 탐색하기~~
        // 2. 모든 육지 점에 대해서 BFS 수행하기
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (graph[i][j] == 1) {
                    answer = max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int y, int x) {
        int[][] depth = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                depth[i][j] = -1;
            }
        }

       Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(y, x));
        depth[y][x] = 0;
        int maxPath = 0;
        int ny = y;
        int nx = x;


        while (!q.isEmpty()) {
            Pair front = q.remove();
            y = front.y;
            x = front.x;
            visited[y][x] = 1;      // 방문처리

            for (int i = 0; i < 4; i++) {
                ny = y + direction[i][0];
                nx = x + direction[i][1];

                if (0 > ny || ny >= H || 0 > nx || nx >= W || graph[ny][nx] == 0) {
                    continue;
                }

                if (depth[ny][nx] == -1) {
                    depth[ny][nx] = depth[y][x] + 1;
                    q.add(new Pair(ny, nx));
                } else if (depth[ny][nx] >= depth[y][x] + 1 && visited[ny][nx] == 0) {
                    depth[ny][nx] = depth[y][x] + 1;
                    q.add(new Pair(ny, nx));
                    visited[ny][nx] = 1;
                }
                maxPath = max(depth[ny][nx], maxPath);
            }
        }
        return maxPath;
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}


//3 3
//LLW
//WWW
//WWW


//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < W; j++) {
//                System.out.print(depth[i][j]);
//            }
//            System.out.println();
//        }
//
//        System.out.println("재탐색 시작점 = " + sy + "행 " + sx + "열");