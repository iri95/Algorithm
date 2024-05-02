package lv2;

import java.util.*;

public class 무인도여행 {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public int[] solution(String[] maps) {
        int[] answer = {-1};
        int N = maps.length;
        int M = maps[0].length();
        boolean[][] visited = new boolean[N][M];
        List<Integer> list = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || maps[i].charAt(j) == 'X') continue;
                q.add(new int[]{i, j});
                int count = maps[i].charAt(j) - '0';
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    for (int n = 0; n < 4; n++) {
                        int ny = p[0] + dy[n];
                        int nx = p[1] + dx[n];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || maps[ny].charAt(nx) == 'X')
                            continue;
                        count += maps[ny].charAt(nx) - '0';
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
                if (count != 0) list.add(count);
            }
        }

        if (list.size() > 0) {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        }

        return answer;
    }
}
