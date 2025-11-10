package graph.graph_structure.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_4195 {

    static int[] parent;
    static int[] size;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            Map<String, Integer> nameMap = new HashMap<>();

            parent = new int[F * 2];
            size = new int[F * 2];
            idx = 0;

            for (int j = 0; j < F; j++) {
                String[] names = br.readLine().split(" ");
                if (!nameMap.containsKey(names[0])) {
                    nameMap.put(names[0], idx);
                    parent[idx] = idx;
                    size[idx] = 1;
                    idx++;
                }
                if (!nameMap.containsKey(names[1])) {
                    nameMap.put(names[1], idx);
                    parent[idx] = idx;
                    size[idx] = 1;
                    idx++;
                }
                int a = nameMap.get(names[0]);
                int b = nameMap.get(names[1]);
                System.out.println(union(a, b));
            }
        }
    }

    private static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return size[rootA];
    }


    // nodeNum의 루트를 찾음
    private static int find(int nodeNum) {
        if (parent[nodeNum] == nodeNum) {
            return nodeNum;
        }
        return parent[nodeNum] = find(parent[nodeNum]);
    }


}
