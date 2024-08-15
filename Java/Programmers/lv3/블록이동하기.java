package lv3;

import java.util.ArrayDeque;
import java.util.Queue;

public class 블록이동하기 {
    static int N;
    // 이동 위 아래 왼 오
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    // 회전 왼쪽 축 90/ -90, 오른쪽 축 90/ -90, 위쪽 축 90/ -90, 아래 축 90/-90 더 작은 좌표(y, x)
    static int[] spinY = {1, 0, 0, 1, -1, -1, 0, 0};
    static int[] spinX = {-1, -1, 0, 0, 0, 1, 1, 0};
    static boolean[][][] visited;

    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        visited = new boolean[N][N][2];
        Queue<int[]> q = new ArrayDeque<>(); // int[] : y, x, dir(가로 0, 세로 1)
        q.add(new int[]{0, 1, 0});
        visited[0][1][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            while (size-- > 0) {
                int[] robot = q.poll();
                for (int i = 0; i < 4; i++) {
                    if (canMove(board, robot, i)) {
                        int ny = robot[0] + dy[i];
                        int nx = robot[1] + dx[i];
                        if (visited[ny][nx][robot[2]]) continue;
                        if (ny == N - 1 && nx == N - 1) return answer;
                        visited[ny][nx][robot[2]] = true;
                        q.add(new int[]{ny, nx, robot[2]});
                    }
                }
                for (int i = 4 * robot[2]; i < 4 * robot[2] + 4; i++) {
                    if (canSpin(board, robot, i)) {
                        int ny = robot[0] + spinY[i];
                        int nx = robot[1] + spinX[i];
                        int nDir = (robot[2] + 1) % 2;
                        if (visited[ny][nx][nDir]) continue;
                        if (ny == N - 1 && nx == N - 1) return answer;
                        visited[ny][nx][nDir] = true;
                        q.add(new int[]{ny, nx, nDir});
                    }
                }
            }
        }
        return answer;
    }

    // 회전 가능 여부, 왼쪽 축 90/ -90, 오른쪽 축 90/ -90, 위쪽 축 90/ -90, 아래 축 90/-90
    private static boolean canSpin(int[][] board, int[] robot, int spin) {
        int y = robot[0];
        int x = robot[1];
        int dir = robot[2];
        if (dir == 0) {
            if (spin == 0 || spin == 3) { // 아래
                return y + 1 < N && board[y + 1][x] == 0 && board[y + 1][x - 1] == 0;
            } else { // 위
                return y - 1 >= 0 && board[y - 1][x] == 0 && board[y - 1][x - 1] == 0;
            }
        } else {
            if (spin == 4 || spin == 7) { // 왼
                return x - 1 >= 0 && board[y][x - 1] == 0 && board[y - 1][x - 1] == 0;
            } else { // 오
                return x + 1 < N && board[y][x + 1] == 0 && board[y - 1][x + 1] == 0;
            }
        }
    }

    // 이동 가능 여부
    private static boolean canMove(int[][] board, int[] robot, int move) {
        int y = robot[0];
        int x = robot[1];
        int dir = robot[2];
        if (dir == 0) {
            if (move == 0) {
                return y - 1 >= 0 && board[y - 1][x] == 0 && board[y - 1][x - 1] == 0;
            } else if (move == 1) {
                return y + 1 < N && board[y + 1][x] == 0 && board[y + 1][x - 1] == 0;
            } else if (move == 2) {
                return x - 2 >= 0 && board[y][x - 2] == 0;
            } else {
                return x + 1 < N && board[y][x + 1] == 0;
            }
        } else {
            if (move == 0) {
                return y - 2 >= 0 && board[y - 2][x] == 0;
            } else if (move == 1) {
                return y + 1 < N && board[y + 1][x] == 0;
            } else if (move == 2) {
                return x - 1 >= 0 && board[y][x - 1] == 0 && board[y - 1][x - 1] == 0;
            } else {
                return x + 1 < N && board[y][x + 1] == 0 && board[y - 1][x + 1] == 0;
            }
        }
    }
}
