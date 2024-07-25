package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1451_직사각형으로나누기 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j + 1] = map[i - 1][j + 1] + map[i][j] + (str.charAt(j) - '0') - map[i - 1][j];
        }
        long max = 0;
        // 세로 긴 직사각형 3개
        if (M >= 3)
            for (int i = 1; i < M - 1; i++)
                for (int j = i + 1; j < M; j++)
                    max = Math.max(max, (long) value(N, i, 0, 0) * value(N, j, 0, i) * value(N, M, 0, j));

        // 가로 긴 직사각형 3개
        if (N >= 3)
            for (int i = 1; i < N - 1; i++)
                for (int j = i + 1; j < N; j++)
                    max = Math.max(max, (long) value(i, M, 0, 0) * value(j, M, i, 0) * value(N, M, j, 0));

        if (N >= 2 && M >= 2) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    // 왼쪽 벽에 직사각형 1개인 경우(ㅏ)
                    max = Math.max(max, (long) value(N, j, 0, 0) * value(i, M, 0, j) * value(N, M, i, j));
                    // 오른쪽 벽(ㅓ)
                    max = Math.max(max, (long) value(i, j, 0, 0) * value(N, j, i, 0) * value(N, M, 0, j));
                    // 위쪽 벽(ㅜ)
                    max = Math.max(max, (long) value(i, M, 0, 0) * value(N, j, i, 0) * value(N, M, i, j));
                    // 아래쪽 벽(ㅗ)
                    max = Math.max(max, (long) value(i, j, 0, 0) * value(i, M, 0, j) * value(N, M, i, 0));
                }
            }
        }
        System.out.println(max);
    }

    private static int value(int y, int x, int my, int mx) {
        if (my == 0 && mx == 0) return map[y][x];
        else if (my == 0) return map[y][x] - map[y][mx];
        else if (mx == 0) return map[y][x] - map[my][x];
        return map[y][x] - map[my][x] - map[y][mx] + map[my][mx];
    }
}
