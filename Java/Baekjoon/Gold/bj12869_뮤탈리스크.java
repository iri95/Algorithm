package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12869_뮤탈리스크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scv = new int[3];
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][][] visited = new boolean[61][61][61];
        int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 0});
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int ns1 = Math.min(60, p[0] + attack[i][0]);
                    int ns2 = Math.min(60, p[1] + attack[i][1]);
                    int ns3 = Math.min(60, p[2] + attack[i][2]);
                    if (visited[ns1][ns2][ns3]) continue;
                    if (ns1 >= scv[0] && ns2 >= scv[1] && ns3 >= scv[2]) {
                        System.out.println(count);
                        return;
                    }
                    visited[ns1][ns2][ns3] = true;
                    queue.add(new int[]{ns1, ns2, ns3});
                }
            }
        }
    }
}
