package lv3;

import java.util.*;

public class 경주로건설 {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};
        boolean[][][] visited = new boolean[N][N][4];
        Arrays.fill(visited[0][0], true);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, -1, 0}); // y, x, 방향, cost
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == N - 1 && p[1] == N - 1) {
                answer = Math.min(answer, p[3]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1) continue;

                int cost = p[3];
                if (p[2] == i || p[2] == -1) cost += 100;
                else cost += 600;

                if (!visited[ny][nx][i] || board[ny][nx] >= cost) {
                    visited[ny][nx][i] = true;
                    board[ny][nx] = cost;
                    q.add(new int[]{ny, nx, i, cost});
                }
            }
        }

        return answer;
    }
}
