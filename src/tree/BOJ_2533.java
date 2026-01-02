package tree;

import java.io.*;
import java.util.*;

public class BOJ_2533 {
    static int N;
    static int[][] edges;
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        // 1. 입력받아서 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new int[N-1][2];
        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            edges[i][0] = u;
            edges[i][1] = v;
        }

        /**
         * 주의 : 이 문제의 간선은 무방향이다!!
         * 정렬을 한다고 해서 u가 부모, ,v가 자식이 되지 않는다.
         * TODO. 임의의 루프(보통 1)를 잡고 dfs/bfs로 방문하면서 parent를 확정해야한다.
         */

        // 2. edge 정렬
        Arrays.sort(edges, (o1, o2)
                -> o1[0] != o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]
        );
        
        // 3. Node 객체를 통해 트리 표현
        tree = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i);
            tree[i] = node;
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree[child].parent = tree[parent];
            tree[child].depth = tree[parent].depth + 1;
            tree[parent].children.add(tree[child]);
        }
        
        // 4. 리프노드 구하기
        List<Node> leaf = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            if (tree[i].children.isEmpty()) {
                leaf.add(tree[i]);
            }
        }

        // 5. 모든 리프노드에 대해서, 어느 조상들이 얼리어답터가 되어야 하는지 구하기
        boolean[] answer = new boolean[N + 1];      // true = 얼리어답터여야 하는 부모 수
        for (Node node : leaf) {
            if (node.depth % 2 == 1) {
                // 홀수 + 리프의 부모만 ea
                Node next = node.parent;
                if (next == null) {
                    continue;
                }
                answer[next.value] = true;
                next = next.parent;
                while (next != null) {
                    if (next.depth % 2 == 1) {
                        answer[next.value] = true;
                    }
                    next = next.parent;
                }
            } else {
                // 홀수들만 ea
                Node next = node.parent;
                while (next != null) {
                    if (next.depth % 2 == 1) {
                        answer[next.value] = true;
                    }
                    next = next.parent;
                }
            }
        }

        int count = 0;
        for (boolean a : answer) {
            if (a) {
                count++;
            }
        }
        System.out.println(count);
    }
    
    static class Node {
        public int value;
        public int depth;
        public Node parent;
        public List<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, int depth, Node parent) {
            this.value = value;
            this.depth = depth;
            this.parent = parent;
        }
    }
}
