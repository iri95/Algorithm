package lv2;

import java.util.Arrays;

public class 삼각달팽이 {
    public static int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] map = new int[n][n];
        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};
        int index = 0;
        int y = 0;
        int x = 0;
        for (int i = 1; i <= n * (n + 1) / 2; i++) {
            map[y][x] = i;
            int ny = y + dy[index];
            int nx = x + dx[index];
            if (ny >= n || ny < 0 || nx >= n || nx < 0 || map[ny][nx] != 0) index = (index + 1) % 3;
            y = y + dy[index];
            x = x + dx[index];
        }
        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) break;
                answer[index] = map[i][j];
                index++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }
}
