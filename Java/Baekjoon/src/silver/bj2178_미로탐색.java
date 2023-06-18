package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178_미로탐색 {
    static int N, M;
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
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if(c == '0')visit[i][j] = true;
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0,0});
        int cnt = 1;
        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx])continue;
                    map[ny][nx] = cnt;
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        System.out.println(map[N-1][M-1]);
    }
}
