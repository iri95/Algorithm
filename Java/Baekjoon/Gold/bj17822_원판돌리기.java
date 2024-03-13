package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17822_원판돌리기 {
    static int N, M, count;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] disc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = N * M;
        int T = Integer.parseInt(st.nextToken());
        disc = new int[N + 1][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                disc[i][j] = Integer.parseInt(st.nextToken());
            }
            disc[i][0] = disc[i][M];
            disc[i][M + 1] = disc[i][1];
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            rotation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (!rotationEnd()) notMeet();
        }
        System.out.println(sum());
    }

    // x.의 배수
    // d : 0 시계, 1 반시계
    // K 번 회전
    static void rotation(int x, int d, int k) {
        while (k-- > 0) {
            for (int n = x; n <= N; n += x) {
                if (d == 0) for (int i = M; i > 0; i--) disc[n][i] = disc[n][i - 1];
                else for (int i = 1; i <= M; i++) disc[n][i] = disc[n][i + 1];
                disc[n][0] = disc[n][M];
                disc[n][M + 1] = disc[n][1];
            }
        }
    }

    // 인접한 같은 수 있는지?
    // 있다면 인접한 수 모두 지움 (BFS)
    // 끝 끼리도 해야함.
    static boolean rotationEnd() {
        boolean result = false;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int num = disc[i][j];
                if (num == 0) continue;
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] p = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = p[0] + dy[k];
                        int nx = p[1] + dx[k];
                        if (nx == 0) nx = M;
                        else if (nx == M + 1) nx = 1;
                        if (ny <= 0 || ny > N || disc[ny][nx] != num) continue;
                        if (disc[i][j] == num) disc[i][j] = 0;
                        result = true;
                        disc[ny][nx] = 0;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        for (int n = 1; n <= N; n++) {
            disc[n][0] = disc[n][M];
            disc[n][M + 1] = disc[n][1];
        }
        return result;
    }

    // 인접한 수 없을 경우 원판 모두의 평균을 구해 평균보다 작은 수는 +, 큰 수는 -
    static void notMeet() {
        int sum = sum();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (disc[i][j] == 0) continue;
                if (disc[i][j] * count > sum) disc[i][j]--;
                else if (disc[i][j] * count < sum) disc[i][j]++;
            }
            disc[i][0] = disc[i][M];
            disc[i][M + 1] = disc[i][1];
        }
    }

    // 원판의 합을 출력
    static int sum() {
        int answer = 0;
        count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (disc[i][j] == 0) continue;
                count++;
                answer += disc[i][j];
            }
        }
        return answer;
    }
}
