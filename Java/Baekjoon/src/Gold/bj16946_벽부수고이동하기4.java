package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// no sol timeout => map, set 사용하기
public class bj16946_벽부수고이동하기4 {
    static int N, M, cnt;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static List<int[]> point = new ArrayList<>();
    static List<int[]> zero = new ArrayList<>();
    static int[][] map;
    static boolean[][] visit, visitWall;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        visit = new boolean[N+2][M+2];
        visitWall = new boolean[N+2][M+2];

        for (int i = 1; i <= N; i++) {
            String array = br.readLine();
            for (int j = 0; j < M; j++) {
                if(array.charAt(j) == '1'){
                    map[i][j+1] = 1;
                    visit[i][j+1] = true;
                }else{
                    zero.add(new int[] {i, j+1});
                }
            }
        }

        for (int[] po: zero
             ) {
            int i = po[0];
            int j = po[1];
            if(visit[i][j])continue;
            cnt = 0;
            bfs(i,j);
            for (int[] p: point) {
                for (int k = 0; k < 4; k++) {
                    int y = p[0] + dy[k];
                    int x = p[1] + dx[k];
                    if(map[y][x] != 0 && !visitWall[y][x]){
                        map[y][x] += cnt;
                        visitWall[y][x] = true;
                    }
                }
            }
            visitWall = new boolean[N + 2][M + 2];
            point.clear();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(map[i][j]%10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    // 벽이 아닌 곳의 이동가능한 칸의 개수를 구하는 함수
    static void bfs(int y, int x) {
        visit[y][x] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        point.add(new int[]{y, x});
        queue.offer(new int[]{y, x});
        while (!queue.isEmpty()) {
            cnt++;
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if(ny > N || nx > M || ny <= 0 || nx <= 0 || visit[ny][nx])continue;
                visit[ny][nx] = true;
                point.add(new int[]{ny, nx});
                queue.offer(new int[]{ny, nx});
            }
        }
    }
//    static void dfs(int y, int x){
//        visit[y][x] = true;
//        point.add(new int[]{y, x});
//        cnt++;
//        for (int i = 0; i < 4; i++) {
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//            if(ny > N || nx > M || ny <= 0 || nx <= 0 || visit[ny][nx])continue;
//            dfs(ny, nx);
//        }
//    }
}
