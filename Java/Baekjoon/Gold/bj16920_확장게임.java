package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16920_확장게임 {
    static int N, M, allCount;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] count;
    static Queue<int[]>[] q;
    static int[] S;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        S = new int[P + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        map = new char[N][M];
        q = new Queue[P + 1];
        allCount = 0;
        count = new int[P + 1];
        int points = N * M;
        for (int i = 0; i <= P; i++) {
            q[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#') {
                    points--;
                    continue;
                }
                if (map[i][j] == '.') continue;
                int num = map[i][j] - '0';
                q[num].add(new int[]{i, j, 0});
                allCount++;
                count[num]++;
            }
        }
        while (allCount < points) {
            boolean can = false;
            for (int p = 1; p <= P; p++) {
                if (!q[p].isEmpty()) can = true;
                bfs(p);
            }
            if (!can) break;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(int p) {
        while (!q[p].isEmpty()) {
            int[] point = q[p].poll();
            if (point[2] >= S[p]) {
                q[p].add(point);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] != '.') continue;
                map[ny][nx] = (char) (p + '0');
                count[p]++;
                allCount++;
                q[p].add(new int[]{ny, nx, point[2] + 1});
            }
        }
        int size = q[p].size();
        while (size-- > 0) {
            int[] point = q[p].poll();
            point[2] = 0;
            q[p].add(point);
        }
    }
}
