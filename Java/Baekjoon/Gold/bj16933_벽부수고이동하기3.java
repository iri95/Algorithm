package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16933_벽부수고이동하기3 {
    static int N, M, K;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] map;
    static int[][][] result;
    static boolean[][][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        result = new int[K+1][N+1][M+1];
        visit = new boolean[K+1][N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j+1] = Character.getNumericValue(str.charAt(j));
            }
        }
        for (int i = 0; i <= K; i++) {
            result[i][N][M] = Integer.MAX_VALUE;
        }
        bfs();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            min = Math.min(min, result[i][N][M]);
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 1, 0, 1});
        visit[0][1][1] = true;
        result[0][1][1] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                int k = p[2];
                int cnt = p[3];
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if(ny <= 0 || nx <= 0 || ny > N || nx > M)continue;
                    if (map[ny][nx] == 1) {
                        if (k + 1 <= K && !visit[k+1][ny][nx]) {
                            if((cnt + 1)%2 == 0) {
                                visit[k + 1][ny][nx] = true;
                                result[k + 1][ny][nx] = cnt + 1;
                                queue.offer(new int[]{ny, nx, k + 1, cnt+1});
                            }else{
                                visit[k][p[0]][p[1]] = false;
                                queue.offer(new int[]{p[0], p[1], k, cnt + 1});
                            }
                        }else continue;
                    }else{
                        if(visit[k][ny][nx])continue;
                        visit[k][ny][nx] = true;
                        result[k][ny][nx] = cnt + 1;
                        queue.offer(new int[]{ny, nx, k, cnt + 1});
                    }
                }
            }
        }
    }
}
