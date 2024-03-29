import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21610_마법사상어와비바라기 {
    static int N, M;
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] basket;
    static boolean[][] visited;
    static Queue<int[]> cloud = new ArrayDeque<>();
    static Queue<int[]> waterCopyBug = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        basket = new int[N][N];
        visited = new boolean[N][N];
        cloud.add(new int[]{N - 1, 0});
        cloud.add(new int[]{N - 2, 0});
        cloud.add(new int[]{N - 1, 1});
        cloud.add(new int[]{N - 2, 1});
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                basket[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            move(d, s);
            copy();
            cloudCreate();
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += basket[i][j];
            }
        }
        System.out.println(sum);

    }
    static void move(int d, int s){
        while (!cloud.isEmpty()) {
            int[] p = cloud.poll();
            int y = p[0];
            int x = p[1];
            // 물 이동
            int ny = (y + (dy[d] + N) * s) % N;
            int nx = (x + (dx[d] + N) * s) % N;
            // 비 내림
            basket[ny][nx]++;
            visited[ny][nx] = true;

            // 구름 위치를 waterCopyBug에 추가
            waterCopyBug.add(new int[]{ny, nx});
        }
    }
    static void copy(){
        // copy
        while (!waterCopyBug.isEmpty()) {
            int[] p = waterCopyBug.poll();
            int y = p[0];
            int x = p[1];
            for (int i = 2; i <= 8; i += 2) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || basket[ny][nx] == 0) continue;
                basket[y][x]++;
            }
        }
    }
    static void cloudCreate(){
        // 구름 생성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                if (basket[i][j] >= 2) {
                    cloud.add(new int[]{i, j});
                    basket[i][j] -= 2;
                }
            }
        }

        // 구름 방문 기록 초기화
        visited = new boolean[N][N];
    }

}
