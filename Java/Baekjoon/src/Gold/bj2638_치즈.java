package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2638_치즈 {
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
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
        int result = 0;
        while(true){
            result++;
            bfs();
            boolean a = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1) {
                        a = true;
                        break;
                    }
                }
                if(a)break;
            }
            if(!a)break;

        }
        System.out.println(result);



    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        int[][] mapCnt = new int[N][M];
        visit = new boolean[N][M];
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if(ny <0 || ny >=N || nx < 0 || nx >= M || visit[ny][nx])continue;
                if (map[ny][nx] == 0) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                } else if (map[ny][nx] == 1) {
                    mapCnt[ny][nx]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapCnt[i][j] > 1) {
                    map[i][j] = 0;
                }
            }
        }
    }
}
