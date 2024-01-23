package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18430_무기공학 {
    static int N, M, result = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 0, 0);
        System.out.println(result);
    }

    private static void solution(int y, int x, int sum) {
        if (sum > result) result = sum;
        for (int i = y; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                for (int k = 0; k < 4; k++) {
                    int ny1 = i + dy[k];
                    int nx1 = j + dx[k];
                    int ny2 = i + dy[(k + 1) % 4];
                    int nx2 = j + dx[(k + 1) % 4];
                    if (ny1 < 0 || ny1 >= N || nx1 < 0 || nx1 >= M ||
                            ny2 < 0 || ny2 >= N || nx2 < 0 || nx2 >= M ||
                            visit[ny1][nx1] || visit[ny2][nx2]) continue;
                    visit[i][j] = true;
                    visit[ny1][nx1] = true;
                    visit[ny2][nx2] = true;
                    solution(i, j, sum + map[i][j] * 2 + map[ny1][nx1] + map[ny2][nx2]);
                    visit[i][j] = false;
                    visit[ny1][nx1] = false;
                    visit[ny2][nx2] = false;
                }
            }
        }
    }
}
