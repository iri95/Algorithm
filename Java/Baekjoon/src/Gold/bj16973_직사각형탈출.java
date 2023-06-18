package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16973_직사각형탈출 {
    static int N, M, H, W, Sr, Sc, Fr, Fc;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken())-1;
        Sc = Integer.parseInt(st.nextToken())-1;
        Fr = Integer.parseInt(st.nextToken())-1;
        Fc = Integer.parseInt(st.nextToken())-1;
        if (Fr >= N - H + 1 || Fc >= M - W + 1) {
            System.out.println(-1);
            return;
        }else if(Sr == Fr && Sc == Fc){
            System.out.println(0);
            return;
        }
        visit = new boolean[N- H + 1][M - W + 1];
        for (int i = 0; i < N - H + 1; i++) {
            for (int j = 0; j < M - W + 1; j++) {
                for (int y = i; y < i+H; y++) {
                    for (int x = j; x < j+W; x++) {
                        if(map[y][x] == 1) {
                            visit[i][j] = true;
                            break;
                        }
                    }
                    if(visit[i][j])break;
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        visit[Sr][Sc] = true;
        queue.offer(new int[]{Sr, Sc});
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if(ny < 0 || nx < 0 || ny >= N- H + 1 || nx >= M - W + 1 || visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                    if(ny == Fr && nx == Fc) {
                        System.out.println(cnt);
                        return;
                    }
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        System.out.println(-1);
    }
}
