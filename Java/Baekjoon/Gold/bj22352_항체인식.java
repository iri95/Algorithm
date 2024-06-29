package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj22352_항체인식 {
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map, resultMap;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        resultMap = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) resultMap[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == resultMap[i][j]) bfs(i, j);
                else {
                    bfs(i, j, resultMap[i][j]);
                    System.out.println(answer());
                    return;
                }
            }
        }
        System.out.println(answer());
    }

    static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        int k = map[y][x];
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || ny>= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny][nx] != k) continue;
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }

    static void bfs(int y, int x, int value){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        int k = map[y][x];
        map[y][x] = value;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || ny>= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny][nx] != k) continue;
                visited[ny][nx] = true;
                map[ny][nx] = value;
                q.add(new int[]{ny, nx});
            }
        }
    }

    static String answer(){
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] != resultMap[i][j]) return "NO";
        return "YES";
    }
}
