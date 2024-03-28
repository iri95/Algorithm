package lv2;

import java.util.*;

public class 전력망을둘로나누기 {
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                boolean[] visit = new boolean[n + 1];
                Queue<Integer> queue = new ArrayDeque<>();
                int k = list[i].get(j);
                int count = 1;
                visit[i] = true;
                visit[k] = true;
                queue.add(k);
                while (!queue.isEmpty()) {
                    int p = queue.poll();
                    for (int next : list[p]) {
                        if (visit[next]) continue;
                        count++;
                        queue.add(next);
                        visit[next] = true;
                    }
                }
                answer = Math.min(answer, Math.abs(n - count * 2));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        System.out.println(solution(4, new int[][] {{1,2},{2,3},{3,4}}));
        System.out.println(solution(7, new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }
}
