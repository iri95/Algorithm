package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj5214_환승 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[N + 1]; // 해당 역을 포함한 하이퍼 튜브
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int[][] connect = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                connect[i][j] = Integer.parseInt(st.nextToken());
                list[connect[i][j]].add(i);
            }
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[M];
        q.add(new int[]{1, 1});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int hi: list[p[0]]) {
                if (visited[hi]) continue;
                for (int i = 0; i < K; i++) {
                    int now = connect[hi][i];
                    if (now == N) {
                        System.out.println(p[1] + 1);
                        return;
                    }
                    q.add(new int[]{now, p[1] + 1});
                }
                visited[hi] = true;
            }
        }
        System.out.println(-1);
    }
}
