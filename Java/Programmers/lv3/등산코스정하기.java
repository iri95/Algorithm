package lv3;

import java.util.*;

public class 등산코스정하기 {
    static int[] answer = {-1, 10_000_001};
    static List<int[]>[] edges;
    static Set<Integer> sum = new HashSet<>();
    static Set<Integer> gate = new HashSet<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        Arrays.sort(summits);

        for (int summit : summits) sum.add(summit);

        for (int j : gates) gate.add(j);

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();

        int e = 0;
        for (int[] path : paths) {
            edges[path[0]].add(new int[]{path[1], path[2]});
            edges[path[1]].add(new int[]{path[0], path[2]});
            e = Math.max(e, path[2]);
        }

        e++;

        for (int i : gates) {
            int start = 0;
            while (start < e) {
                int mid = (start + e) / 2;
                if (bfs(n, i, mid)) {
                    e = mid;
                } else {
                    start = mid + 1;
                }
            }
            e++;
        }

        return answer;
    }

    private static boolean bfs(int n, int s, int limit) {
        boolean[] visited = new boolean[n + 1];
        visited[s] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        boolean flag = false;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : edges[cur]) {
                if (next[1] > limit || visited[next[0]] || gate.contains(next[0])) continue;
                visited[next[0]] = true;
                if (sum.contains(next[0])) {
                    if (answer[1] > limit) {
                        answer[1] = limit;
                        answer[0] = next[0];
                    } else if (answer[1] == limit && answer[0] > next[0]) {
                        answer[0] = next[0];
                    }
                    flag = true;
                    continue;
                }
                q.add(next[0]);
            }
        }
        return flag;
    }
}

/* Dijkstra
public class 등산코스정하기 {
    static int[] answer = {-1, 10_000_001};
    static List<int[]>[] edges;
    static Set<Integer> sum = new HashSet<>();
    static Set<Integer> gate = new HashSet<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Arrays.sort(summits);

        for (int summit : summits) sum.add(summit);
        for (int g : gates) gate.add(g);

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int[] path : paths) {
            edges[path[0]].add(new int[]{path[1], path[2]});
            edges[path[1]].add(new int[]{path[0], path[2]});
            answer[1] = Math.max(answer[1], path[2]);
        }

        for (int g : gates) dijkstra(n, g);

        return answer;
    }

    private static void dijkstra(int n, int s) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        boolean[] visited = new boolean[n + 1];
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            for (int[] next : edges[cur[0]]) {
                int max = Math.max(cur[1], next[1]);
                if (answer[1] >= max) {
                    if (sum.contains(next[0])) {
                        if (answer[1] > max) {
                            answer[1] = max;
                            answer[0] = next[0];
                        } else if (answer[0] > next[0]) {
                            answer[0] = next[0];
                        }
                        continue;
                    }
                    if (!gate.contains(next[0]))
                        pq.add(new int[]{next[0], max});
                }
            }
        }
    }
}
*/
