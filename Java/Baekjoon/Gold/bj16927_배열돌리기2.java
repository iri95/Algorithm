package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16927_배열돌리기2 {
    static int N, M, R;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int y = 0;
        int x = 0;
        int count = 0;
        int rCount = Math.min(N, M) / 2; // 회전해야할 원 개수
        while (rCount-- > 0) {
            int div = (N - 2 * count - 1) * 2 + (M - 2 * count - 1) * 2;
            int r = R % div;
            while (r-- > 0) {
                rotation(y, x, count);
            }
            count++;
            y++;
            x++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotation(int y, int x, int count){
        int before = map[y][x];
        int in;
        int d = 0;
        while (d < 4) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < count || ny >= N - count || nx < count || nx >= M - count){
                d++;
                continue;
            }
            in = before;
            before = map[ny][nx];
            map[ny][nx] = in;
            y = ny;
            x = nx;
        }
    }
}
