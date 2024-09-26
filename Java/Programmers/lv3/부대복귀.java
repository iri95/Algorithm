package lv3;

import java.util.*;

public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < roads.length; i++) {
            list[roads[i][0]].add(roads[i][1]);
            list[roads[i][1]].add(roads[i][0]);
        }
        boolean[] visited = new boolean[n + 1];
        int[] cnt = new int[n + 1];
        Arrays.fill(cnt, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(destination);
        cnt[destination] = 0;
        visited[destination] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size-- > 0) {
                int p = q.poll();
                for (int next : list[p]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    cnt[next] = count;
                    q.add(next);
                }
            }
        }
        for (int i = 0; i < sources.length; i++) {
            answer[i] = cnt[sources[i]];
        }
        return answer;
    }

}
