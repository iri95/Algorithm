package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj19238_스타트택시 {
    static int N, M, oil, y, x;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static boolean[] complete;
    static String[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());
        map = new String[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
            }
        }
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        complete = new boolean[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            map[sy][sx] = map[sy][sx].equals("0") ? "S" + i : "S" + i + " " + map[sy][sx];
            map[ey][ex] = map[ey][ex].equals("0") ? "E" + i : map[ey][ex] + " E" + i;
        }
        while (true) {
            int[] user = userFind();
            if (user.length == 1 || user[3] > oil) break;
            oil -= user[3];
            y = user[0];
            x = user[1];
            int[] arrive = drive(user[2]);
            if (arrive.length == 1 || arrive[2] > oil) break;
            oil += arrive[2];
            y = arrive[0];
            x = arrive[1];
            complete[user[2]] = true;
        }
        for (int i = 0; i < M; i++) {
            if (!complete[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(oil);

    }

    // 가장 가까운 승객을 찾는 BFS 함수
    // pq를 사용해 y가 가장 작고 같으면 x가 가장 작은 값을 앞으로
    // 결과로 user의 위치와 번호, 거리를 int[] 담아 반환
    // 만약에 승객이 더 없을 경우 길이가 1인 배열을 반환.
    static int[] userFind() {
        if (map[y][x].charAt(0) == 'S') {
            StringTokenizer st = new StringTokenizer(map[y][x]);
            String str = st.nextToken();
            if (!complete[Integer.parseInt(str.substring(1))])
                return new int[]{y, x, Integer.parseInt(str.substring(1)), 0};
        }
        visit = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> result = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || map[ny][nx].equals("1")) continue;
                    if (map[ny][nx].charAt(0) == 'S') {
                        StringTokenizer st = new StringTokenizer(map[ny][nx]);
                        String str = st.nextToken();
                        if (!complete[Integer.parseInt(str.substring(1))]) {
                            result.add(new int[]{ny, nx, Integer.parseInt(str.substring(1)), count});
                        }
                    }
                    visit[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
            if (!result.isEmpty()) break;
        }
        return result.isEmpty() ? new int[]{0} : result.poll();
    }

    // 승객을 데려다 주는 가장 가까운 거리 BFS
    // 위치, 거리를 반환
    // 목적지에 갈 수 없는 경우라면 길이가 1인 배열을 반환.
    static int[] drive(int number) {
        visit = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || map[ny][nx].equals("1")) continue;
                    if (map[ny][nx].charAt(0) == 'E' || map[ny][nx].charAt(0) == 'S') {
                        StringTokenizer st = new StringTokenizer(map[ny][nx]);
                        while (st.hasMoreTokens()) {
                            String str = st.nextToken();
                            if (str.charAt(0) == 'E' && Integer.parseInt(str.substring(1)) == number) {
                                return new int[]{ny, nx, count};
                            }
                        }
                    }
                    visit[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        return new int[]{0};
    }
}
