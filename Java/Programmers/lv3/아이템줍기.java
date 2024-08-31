package lv3;

import java.util.*;

public class 아이템줍기 {
    static boolean[][] map = new boolean[51][51];
    static boolean[][] mapX = new boolean[51][51]; // 1,1 : 1,1 -> 1,2
    static boolean[][] mapY = new boolean[51][51]; // 1,1 : 1,1 -> 2,1
    static boolean[][] visited = new boolean[51][51];


    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int N = rectangle.length;
        for (int i = 0; i < N; i++) add(rectangle[i]);
        for (int i = 0; i < N; i++) remove(rectangle[i]);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{characterY, characterX});
        visited[characterY][characterX] = true;
        int cnt = 0;
        bfs:
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int[] p = q.poll();
                // U
                int ny = p[0] + 1;
                int nx = p[1];
                if (ny <= 50 && map[ny][nx] && !visited[ny][nx] && mapY[p[0]][p[1]]) {
                    visited[ny][nx] = true;
                    if (ny == itemY && nx == itemX) {
                        answer = cnt;
                        break bfs;
                    }
                    q.add(new int[]{ny, nx});
                }

                // D
                ny = p[0] - 1;
                if (ny >= 0 && map[ny][nx] && !visited[ny][nx] && mapY[ny][nx]) {
                    visited[ny][nx] = true;
                    if (ny == itemY && nx == itemX) {
                        answer = cnt;
                        break bfs;
                    }
                    q.add(new int[]{ny, nx});
                }

                // R
                ny = p[0];
                nx = p[1] + 1;
                if (nx <= 50 && map[ny][nx] && !visited[ny][nx] && mapX[p[0]][p[1]]) {
                    visited[ny][nx] = true;
                    if (ny == itemY && nx == itemX) {
                        answer = cnt;
                        break bfs;
                    }
                    q.add(new int[]{ny, nx});
                }

                // L
                nx = p[1] - 1;
                if (nx >= 0 && map[ny][nx] && !visited[ny][nx] && mapX[ny][nx]) {
                    visited[ny][nx] = true;
                    if (ny == itemY && nx == itemX) {
                        answer = cnt;
                        break bfs;
                    }
                    q.add(new int[]{ny, nx});
                }

            }
        }
        return answer;
    }

    private static void remove(int[] rec) {
        for (int i = rec[1] + 1; i < rec[3]; i++)
            for (int j = rec[0] + 1; j < rec[2]; j++)
                map[i][j] = false;

        for (int i = rec[1] + 1; i < rec[3]; i++)
            for (int j = rec[0]; j < rec[2]; j++)
                mapX[i][j] = false;

        for (int i = rec[1]; i < rec[3]; i++)
            for (int j = rec[0] + 1; j < rec[2]; j++)
                mapY[i][j] = false;
    }

    private static void add(int[] rec) {
        for (int i = rec[1]; i <= rec[3]; i++) {
            map[i][rec[0]] = true;
            map[i][rec[2]] = true;
            if (i != rec[3]) {
                mapY[i][rec[0]] = true;
                mapY[i][rec[2]] = true;
            }
        }

        for (int i = rec[0]; i <= rec[2]; i++) {
            map[rec[1]][i] = true;
            map[rec[3]][i] = true;
            if (i != rec[2]) {
                mapX[rec[1]][i] = true;
                mapX[rec[3]][i] = true;
            }
        }
    }
}