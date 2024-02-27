package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
자릿수가 클수로 값이 큰건 당연한거
4 * 4 인 경우 4자릿수를 하나 만들어야 함
그리고 남은 4 * 3에서 가장 큰 경우 -> 4자릿수 3개를 더하기, 3자릿수 4개를 더하기
visit = visit | 1 << M * y + x
 */
public class bj14391_종이조각 {
    static int max, N, M, visit = 0, allVisit;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        allVisit = (int) Math.pow(2, N * M) - 1;
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        dfs(0, M - 1, 0, N - 1, 0, 0);
        System.out.println(max);
    }

    static void dfs(int sx, int ex, int sy, int ey, int visit, int sum) {
        if (visit == allVisit) {
            max = Math.max(sum, max);
            return;
        }
        if (sx >= M || ex < 0 || sy >= N || ey < 0) return;
        StringBuilder str = new StringBuilder();
        int visit1 = visit & allVisit;
        if (sy <= ey && sx <= ex) {
            for (int i = sy; i <= ey; i++) {
                str.append(map[i][sx]);
                visit1 = visit1 | 1 << (M * i + sx);
            }
            dfs(sx + 1, ex, sy, ey, visit1, sum + Integer.parseInt(str.toString()));

            str = new StringBuilder();
            visit1 = visit & allVisit;
            for (int i = sy; i <= ey; i++) {
                str.append(map[i][ex]);
                visit1 = visit1 | 1 << (M * i + ex);
            }
            dfs(sx, ex - 1, sy, ey, visit1, sum + Integer.parseInt(str.toString()));

            str = new StringBuilder();
            visit1 = visit & allVisit;
            for (int i = sx; i <= ex; i++) {
                str.append(map[sy][i]);
                visit1 = visit1 | 1 << (M * sy + i);
            }
            dfs(sx, ex, sy + 1, ey, visit1, sum + Integer.parseInt(str.toString()));

            str = new StringBuilder();
            visit1 = visit & allVisit;
            for (int i = sx; i <= ex; i++) {
                str.append(map[ey][i]);
                visit1 = visit1 | 1 << (M * ey + i);
            }
            dfs(sx, ex, sy, ey - 1, visit1, sum + Integer.parseInt(str.toString()));
        }
    }
}
