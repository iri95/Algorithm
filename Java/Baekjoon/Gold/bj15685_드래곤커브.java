package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15685_드래곤커브 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};
        List<int[]>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            list[i].add(new int[]{y, x, d, y + dy[d], x + dx[d]});
            for (int j = 0; j < g; j++) {
                for (int k = list[i].size() - 1; k >= 0; k--) {
                    int startY = list[i].get(list[i].size() - 1)[3];
                    int startX = list[i].get(list[i].size() - 1)[4];
                    int nd = (list[i].get(k)[2] + 1) % 4;
                    list[i].add(new int[]{startY, startX, nd, startY + dy[nd], startX + dx[nd]});
                }
            }
        }
        boolean[][] map = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            map[list[i].get(0)[0]][list[i].get(0)[1]] = true;
            for (int j = 0; j < list[i].size(); j++) {
                map[list[i].get(j)[3]][list[i].get(j)[4]] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
