package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj9370_미확인도착지 {
    static int T, n, m, t, s, g, h, INF = Integer.MAX_VALUE;
    static List<Integer> list;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(map[i], INF);
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = map[b][a] = Integer.parseInt(st.nextToken());
            }
            list = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(list);
            // g,h 중에 최단거리가 짧은 걸 먼저 방문 후 g-h, 긴 교차로 -> 목적지 값들을 모두 더한 값이 최단거리일 경우 정답
            int[] distance = new int[n + 1];
            dijkstra(distance, s);
            int[] dis = new int[n + 1];
            if (distance[g] > distance[h]) {
                dijkstra(dis, g);
                for (Integer i : list)
                    if (distance[i] == distance[h] + map[h][g] + dis[i]) sb.append(i).append(" ");
            } else if (distance[g] < distance[h]) {
                dijkstra(dis, h);
                for (Integer i : list)
                    if (distance[i] == distance[g] + map[g][h] + dis[i]) sb.append(i).append(" ");
            } else {
                int[] dis2 = new int[n + 1];
                dijkstra(dis, g);
                dijkstra(dis2, h);
                for (Integer i : list) {
                    if (distance[i] == distance[h] + map[h][g] + dis[i]) sb.append(i).append(" ");
                    else if (distance[i] == distance[g] + map[g][h] + dis[i]) sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int[] distance, int s) {
        Arrays.fill(distance, INF);
        distance[s] = 0;
        boolean[] visited = new boolean[n + 1];
        visited[s] = true;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 1; i <= n; i++) {
            if (map[s][i] != INF) {
                pq.add(new int[]{i, map[s][i]});
                distance[i] = map[s][i];
            }
        }

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int next = p[0];
            if (visited[next]) continue;
            visited[next] = true;
            for (int i = 1; i <= n; i++) {
                if (visited[i] || map[next][i] == INF) continue;
                if (distance[i] > distance[next] + map[next][i]) {
                    distance[i] = distance[next] + map[next][i];
                    pq.add(new int[]{i, distance[i]});
                }
            }
        }
    }
}
