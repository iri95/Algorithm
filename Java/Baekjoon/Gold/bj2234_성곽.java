package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2234_성곽 {
    static int N, M;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] map;
    static Map<Integer, Integer> rooms = new HashMap<>();
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int volume = 0;
        int maxVolume = 0;
        int[][] numberMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                count++;
                int v = 0;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});
                visit[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] p = queue.poll();
                    v++;
                    int y = p[0];
                    int x = p[1];
                    numberMap[y][x] = count;
                    for (int k = 0; k < 4; k++) {
                        if ((map[y][x] & 1 << k) != 0) continue;
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M || visit[ny][nx]) continue;
                        visit[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
                rooms.put(count, v);
                volume = Math.max(v, volume);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    if ((map[i][j] & 1 << k) == 0) continue;
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || numberMap[i][j] == numberMap[ny][nx]) continue;
                    maxVolume = Math.max(rooms.get(numberMap[i][j]) + rooms.get(numberMap[ny][nx]), maxVolume);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n").append(volume).append("\n").append(maxVolume);
        System.out.println(sb);
    }
}
