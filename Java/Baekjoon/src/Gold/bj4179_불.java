package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class bj4179_불 {
    static int R, C;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[][] visit;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];
        int[] start = new int[2];
        Queue<int[]> fire = new ArrayDeque<>();
        Queue<int[]> position = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#') {
                    visit[i][j] = true;
                } else if (map[i][j] == 'J') {
                    visit[i][j] = true;
                    position.add(new int[]{i, j});
                } else if (map[i][j] == 'F') {
                    visit[i][j] = true;
                    fire.add(new int[]{i, j});
                }
            }
        }
        int cnt = 0;
        while (true) {
            cnt++;
            int fireSize = fire.size();
            int positionSize = position.size();
            while (fireSize-- > 0) {
                int[] p = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny >= R || nx >= C || ny < 0 || nx < 0 || visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                    fire.offer(new int[]{ny, nx});
                }
            }
            while (positionSize-- > 0) {
                int[] p = position.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny >= R || nx >= C || ny < 0 || nx < 0) {
                        System.out.println(cnt);
                        return;
                    }
                    if(visit[ny][nx])continue;
                    visit[ny][nx] = true;
                    position.offer(new int[]{ny, nx});
                }
            }
            if(position.size() == 0)break;
        }
        System.out.println("IMPOSSIBLE");
    }

}
