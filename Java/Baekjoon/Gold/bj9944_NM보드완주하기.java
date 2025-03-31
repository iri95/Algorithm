package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9944_NM보드완주하기 {
    static int N, M, answer, max, INF = 1_000_001;
    static int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 0;
        String line;
        while ((line = br.readLine()) != null) {
            T++;
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = INF;
            max = N * M;
            visited = new boolean[N][M];

            // 보드 초기화 및 장애물 처리
            for (int i = 0; i < N; i++) {
                line = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (line.charAt(j) == '*') {
                        visited[i][j] = true;
                        max--;
                    }
                }
            }

            // 가능한 모든 시작점에서 DFS 실행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) continue;
                    visited[i][j] = true;
                    dfs(i, j, 1, 0);
                    visited[i][j] = false;
                }
            }
            sb.append("Case ").append(T).append(": ")
                    .append(answer == INF ? -1 : answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int y, int x, int count, int move) {
        // 모든 빈칸을 방문했다면 정답 갱신 후 종료
        if (count == max) {
            answer = move;
            return;
        }
        // 현재 이동 횟수가 이미 최소 답보다 크거나 같다면 가지치기
        if (move >= answer) return;

        // 4방향에 대해 진행
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 바로 다음 칸이 유효하지 않다면 해당 방향 건너뛰기
            if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;

            int steps = 0;
            // 해당 방향으로 계속 이동하면서 방문 처리
            while (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]) {
                visited[ny][nx] = true;
                steps++;
                count++;
                ny += dy[d];
                nx += dx[d];
            }
            // 마지막 이동은 범위 벗어나거나 방문한 칸에 도달했으므로 한 칸 뒤로 돌아감
            ny -= dy[d];
            nx -= dx[d];

            // 재귀 호출: 마지막으로 방문한 유효한 위치에서 이동
            dfs(ny, nx, count, move + 1);

            // 백트래킹: 해당 방향으로 이동한 칸들을 모두 미방문 상태로 복원
            while (steps > 0) {
                visited[ny][nx] = false;
                ny -= dy[d];
                nx -= dx[d];
                steps--;
                count--;
            }
        }
    }
}
