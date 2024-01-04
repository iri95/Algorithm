package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1325_효율적인해킹 {
    static int N, M, max;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] resultList;

    static void bfs(int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        visit[i] = true;
        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int j : graph[k]) {
                if (visit[j]) continue;
                visit[j] = true;
                resultList[j]++;
                queue.add(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        resultList = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            bfs(i);
        }
        for (int i = 1; i <= N; i++) if (max < resultList[i]) max = resultList[i];
        for (int i = 1; i <= N; i++) if (max == resultList[i]) System.out.print(i + " ");
    }
}
