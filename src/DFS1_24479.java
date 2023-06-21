import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFS1_24479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        int[][] graphArr = new int[V+1][V+1];
        int [] indexCnt = new int [V+1];
        int order = 1;

        for (int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            indexCnt[a]++;
            int tmp = indexCnt[a];
            graphArr[a][tmp]=b;

            indexCnt[b]++;
            tmp = indexCnt[b];
            graphArr[b][tmp]=a;
        }
        for(int i=1;i<=V;i++){
            Arrays.sort(graphArr[i], 1, indexCnt[i]+1);
        }
        graphArr[startV][0]=order;
        order++;
        int tmp = graphArr[startV][1];
        int index = 1;
        while(true) {
            if(graphArr[tmp][index]==0){
                if(tmp==startV) break;
                index=0;
                order--;
                int find=0;
                for(int i=0;i<=V;i++) {
                    if(graphArr[i][0]==order){
                        find = i;
                    }
                }
                tmp = graphArr[find][index];
            }
            if (graphArr[tmp][0] == 0) {
                graphArr[tmp][0] = order;
                order++;
                tmp = graphArr[tmp][index];
            } else {
                index++;
                tmp = graphArr[tmp][index];
            }
        }

        for(int k=1;k<=V;k++) {
            sb.append(graphArr[k][0]+"\n");
        }
        System.out.println(sb);
    }
}
