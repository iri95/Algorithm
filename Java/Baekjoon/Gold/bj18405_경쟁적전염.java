package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj18405_경쟁적전염 {
    static int N, K;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new int[]{map[i][j], i, j});
                }
            }
        }
        Collections.sort(list, ((o1, o2) -> {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] == o2[0]) return 0;
            else return -1;
        }));
        for (int i = 0; i < list.size(); i++) {
            queue.add(list.get(i));
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        while (S-- > 0) {
            spread();
        }
        System.out.println(map[Y - 1][X - 1]);
    }

    static void spread() {
        int size = queue.size();
        while (size-- > 0) {
            int[] p = queue.poll();
            int num = p[0];
            int y = p[1];
            int x = p[2];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] != 0) continue;
                map[ny][nx] = num;
                queue.add(new int[]{num, ny, nx});
            }
        }
    }
    /*
    public static class virus {
        Queue<int[]> queue = new ArrayDeque<>();
        int number;

        public virus(int number, int[] p) {
            this.number = number;
            queue.add(p);
        }
    }

    static int N, K;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static virus[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new virus[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    int[] p = {i, j};
                    list[map[i][j] - 1] = new virus(map[i][j], p);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        while (S-- > 0) {
            spread();
        }
        System.out.println(map[Y - 1][X - 1]);

    }

    static void spread() {
        for (int i = 0; i < K; i++) {
            if (list[i] == null) continue;
            Queue<int[]> queue = list[i].queue;
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                int y = p[0];
                int x = p[1];
                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] != 0) continue;
                    map[ny][nx] = map[y][x];
                    list[i].queue.add(new int[]{ny, nx});
                }
            }
        }
    }
     */
}
