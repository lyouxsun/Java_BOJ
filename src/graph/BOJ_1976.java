package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 유니온 파인드
public class BOJ_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            String[] num = br.readLine().split(" ");
            for (int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(num[j - 1]);
            }
        }

        int[] seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 0. 부모를 저장하는 배열 생성
        int[] parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        // 1. 이어진 노드끼리 union하기
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (graph[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        for (int i = 0; i < seq.length - 1; i++) {
            if (!find(parent, seq[i], seq[i + 1])) {
                System.out.println("NO");
                return;
            }
        }

//        for (int i = 0; i < N + 1; i++) {
//            System.out.print(parent[i] + " ");
//        }
//        System.out.println();

        System.out.println("YES");
    }


    private static int getParent(int[] parent, int n) {
        if (parent[n] == n) {
            return n;
        }
        parent[n] = getParent(parent, parent[n]);
        return parent[n];
    }

    // parent 배열을 초기화할 때 사용하는 메서드
    private static void union(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    // parent 배열이 완성된 후, a노드와 b노드가 같은 그룹인지 확인하고 싶을 때 사용하는 메서드
    private static boolean find(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }
}
