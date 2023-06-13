package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj22944_죽음의비 {
    static int N, H, D, sx, sy, rx, ry;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        int uCnt = 0;
        for (int i = 0; i < N; i++) {
            String k = br.readLine();
            for (int j = 0; j < N; j++) {
                char a = k.charAt(j);
                if (a == 'S') {
                    sy = i;
                    sx = j;
                } else if (a == 'U') {
                    map[i][j] = -2;
                    uCnt++;
                } else if (a == 'E') {
                    map[i][j] = -1;
                    ry = i;
                    rx = j;
                }
            }
        }
        visit = new boolean[N][N][uCnt+1];

        queue.offer(new int[]{sy, sx, H, 0, 0});
        visit[sy][sx][0] = true;
        bfs();
        System.out.println(map[ry][rx]);

    }
    static void bfs(){
        int cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            while(size-- > 0){
                int[] p = queue.poll();
                if(p[2] == 0)continue;
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    int hp = p[2];
                    int ub = p[3];
                    int ubCnt = p[4];
                    if(ny >= N || nx >= N || ny < 0 || nx < 0 || visit[ny][nx][ubCnt])continue;
                    if(map[ny][nx] == -1){
                        map[ny][nx] = cnt;
                        return;
                    }else if(map[ny][nx] == -2){
                        ub = D - 1;
                        ubCnt++;
                        map[ny][nx] = cnt;
                    }else{
                        map[ny][nx] = cnt;
                        if(ub == 0){
                            hp--;
                        }else{
                            ub--;
                        }
                    }
                    visit[ny][nx][ubCnt] = true;
                    queue.offer(new int[] {ny, nx, hp, ub, ubCnt});
                }
            }
        }


    }
}
