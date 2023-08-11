package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj6593_상범빌딩 {
    static int L, R, C;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static char[][][] map;
    static boolean[][][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)break;

            map = new char[L][R][C];
            visit = new boolean[L][R][C];

            int startX = 0;
            int startY = 0;
            int startZ = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String a = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = a.charAt(k);
                        if (map[i][j][k] == 'S') {
                            startX = k;
                            startY = j;
                            startZ = i;
                        }
                    }
                }
                br.readLine();
            }
            visit[startZ][startY][startX] = true;

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startZ, startY, startX});
            int cnt = 0;
            boolean arrive = false;
            int result = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                cnt++;
                while (size-- > 0) {
                    int[] p = queue.poll();
                    for (int i = 0; i < 6; i++) {
                        int nz = p[0] + dz[i];
                        int ny = p[1] + dy[i];
                        int nx = p[2] + dx[i];
                        if(nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C || visit[nz][ny][nx] || map[nz][ny][nx]  == '#')continue;
                        if (map[nz][ny][nx] == 'E') {
                            arrive = true;
                            result = cnt;
                        }
                        visit[nz][ny][nx] = true;
                        queue.offer(new int[]{nz, ny, nx});
                    }
                }
            }
            if (arrive) {
                sb.append("Escaped in " + result + " minute(s)." + "\n");
            }else{
                sb.append("Trapped!"+ "\n");
            }
        }
        System.out.println(sb);
    }
}
