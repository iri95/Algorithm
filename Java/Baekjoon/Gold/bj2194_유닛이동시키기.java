package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2194_유닛이동시키기 {
    static int N, M, A, B, K;
    static boolean[][] map, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }
        int[] start = new int[2];
        int[] end = new int[2];
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        visited[start[0]][start[1]] = true;
        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int[] p = q.poll();
                int y = p[0];
                int x = p[1];
                if (right(y, x)) {
                    if (y == end[0] && x + 1 == end[1]){
                        System.out.println(cnt);
                        return;
                    }
                    q.add(new int[]{y, x + 1});
                }
                if (left(y, x)) {
                    if (y == end[0] && x - 1 == end[1]){
                        System.out.println(cnt);
                        return;
                    }
                    q.add(new int[]{y, x - 1});
                }
                if (up(y, x)) {
                    if (y - 1 == end[0] && x == end[1]){
                        System.out.println(cnt);
                        return;
                    }
                    q.add(new int[]{y - 1, x});
                }
                if (down(y, x)) {
                    if (y + 1 == end[0] && x == end[1]){
                        System.out.println(cnt);
                        return;
                    }
                    q.add(new int[]{y + 1, x});
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean right(int y, int x) {
        int nx = x + B;
        if (nx > M || visited[y][x + 1]) return false;
        for (int i = 0; i < A; i++) if (map[y + i][nx]) return false;
        visited[y][x + 1] = true;
        return true;
    }

    private static boolean left(int y, int x) {
        int nx = x - 1;
        if (nx <= 0 || visited[y][x - 1]) return false;
        for (int i = 0; i < A; i++) if (map[y + i][nx]) return false;
        visited[y][x - 1] = true;
        return true;
    }

    private static boolean up(int y, int x) {
        int ny = y - 1;
        if (ny <= 0 || visited[y - 1][x]) return false;
        for (int i = 0; i < B; i++) if (map[ny][x + i]) return false;
        visited[y - 1][x] = true;
        return true;
    }

    private static boolean down(int y, int x) {
        int ny = y + A;
        if (ny > N || visited[y + 1][x]) return false;
        for (int i = 0; i < B; i++) if (map[ny][x + i]) return false;
        visited[y + 1][x] = true;
        return true;
    }

}
