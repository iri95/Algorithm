package lv3;

import java.util.*;

public class 양과늑대 {
    private static class State {
        int num, sheep, wolf, state;

        public State(int num, int sheep, int wolf, int state) {
            this.num = num;
            this.sheep = sheep;
            this.wolf = wolf;
            this.state = state;
        }
    }

    public int solution(int[] info, int[][] edges) {
        int answer = 1;
        int N = info.length;
        // 비트마스킹으로 방문 여부 결정해서 늑대와 양의 수를 저장한다.
        // 양의 수와 노드 번호로 방문 처리를 한다.
        boolean[][][] visited = new boolean[N + 1][N][N];
        List<Integer>[] lists = new ArrayList[N];
        for (int i = 0; i < N; i++) lists[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            lists[a].add(b);
            lists[b].add(a);
        }

        Queue<State> q = new ArrayDeque<>();
        q.add(new State(0, 1, 0, 1));
        visited[1][0][0] = true;
        while (!q.isEmpty()) {
            State s = q.poll();
            for (int next : lists[s.num]) {
                if (visited[s.sheep][s.wolf][next] && (s.state & 1 << next) > 0) continue;
                visited[s.sheep][s.wolf][next] = true;
                if ((s.state & 1 << next) > 0) {
                    q.add(new State(next, s.sheep, s.wolf, s.state));
                } else {
                    if (info[next] == 0) {
                        q.add(new State(next, s.sheep + 1, s.wolf, s.state | 1 << next));
                        if (s.sheep + 1 > answer) answer = s.sheep + 1;
                    } else {
                        if (s.sheep <= s.wolf + 1) continue;
                        q.add(new State(next, s.sheep, s.wolf + 1, s.state | 1 << next));
                    }
                }
            }
        }

        return answer;
    }
}
