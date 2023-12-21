package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1916_최소비용구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] map = new ArrayList[N + 1];
        long[][] costMap = new long[N + 1][N + 1];
        long[] result = new long[N + 1];
        Arrays.fill(result, 100000001);

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
            Arrays.fill(costMap[i], 100001);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            map[from].add(to);
            costMap[from][to] = Math.min(cost, costMap[from][to]);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        result[start] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : map[from]) {
                if (result[to] > result[from] + costMap[from][to]) {
                    queue.offer(to);
                    result[to] = result[from] + costMap[from][to];
                }
            }
        }
        System.out.println(result[end]);
    }
}