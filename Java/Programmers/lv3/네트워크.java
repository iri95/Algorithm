package lv3;

import java.util.*;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int p = q.poll();
                for (int j = 0; j < n; j++) {
                    if (p == j || visited[j] || computers[p][j] == 0) continue;
                    q.add(j);
                    visited[j] = true;
                }
            }
            answer++;
        }
        return answer;
    }
}
