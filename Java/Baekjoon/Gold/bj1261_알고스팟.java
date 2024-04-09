package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1261_알고스팟 {
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] map;
    static int[][] count;
    static boolean[][] visit;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        count = new int[N][M];
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            Arrays.fill(count[i], N * M);
            for (int j = 0; j < M; j++) {
                map[i][j] = a.charAt(j) == '1';
            }
        }
        count[0][0] = 0;
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M)continue;
                if (map[ny][nx]) {
                    if (count[ny][nx] > p[2] + 1){
                        count[ny][nx] = p[2] + 1;
                        queue.add(new int[]{ny, nx, p[2] + 1});
                    }
                }else{
                    if (count[ny][nx] > p[2]){
                        count[ny][nx] = p[2];
                        queue.add(new int[]{ny, nx, p[2]});
                    }
                }
            }
        }
        System.out.println(count[N-1][M-1]);
    }
}
