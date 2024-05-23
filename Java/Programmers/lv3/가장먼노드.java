package lv3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int M = edge.length;
        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            lists[a].add(b);
            lists[b].add(a);
        }
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.add(1);
        int before = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            before = answer;
            answer = 0;
            while (size-- > 0) {
                int now = q.poll();
                if (visited[now]) continue;
                visited[now] = true;
                answer++;
                for (int a : lists[now]) {
                    if (!visited[a]) q.add(a);
                }
            }
        }
        return answer == 0 ? before : answer;
    }
}
}
