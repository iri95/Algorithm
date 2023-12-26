import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2174_로봇시뮬레이션 {
    static int A, B, N, M;
    static int[] dy = {1, 0, -1, 0}; // 북 동 남 서
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[B + 1][A + 1];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            map[y][x] = i;
            list[i][0] = y;
            list[i][1] = x;
            if (d == 'N') list[i][2] = 0;
            else if (d == 'E') list[i][2] = 1;
            else if (d == 'S') list[i][2] = 2;
            else if (d == 'W') list[i][2] = 3;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char order = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());
            while (count-- > 0) {
                if (order == 'F') {
                    if (F(num)) {
                        System.out.println(sb);
                        return;
                    }
                } else if (order == 'L') list[num][2] = (list[num][2] + 3) % 4;
                else if (order == 'R') list[num][2] = (list[num][2] + 1) % 4;
            }
        }
        System.out.println("OK");
    }

    static boolean F(int num) {
        int y = list[num][0];
        int x = list[num][1];
        int d = list[num][2];
        int ny = y + dy[d];
        int nx = x + dx[d];
        if (ny <= 0 || ny > B || nx <= 0 || nx > A) {
            if (sb.length() == 0) sb.append("Robot " + num + " crashes into the wall");
            return true;
        }
        if (map[ny][nx] != 0) {
            if (sb.length() == 0) sb.append("Robot " + num + " crashes into robot " + map[ny][nx]);
            return true;
        }
        map[y][x] = 0;
        map[ny][nx] = num;
        list[num][0] = ny;
        list[num][1] = nx;
        return false;
    }
}
