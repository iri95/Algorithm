package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9207_페그솔리테어 {
    static int remain, min;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map = new char[5][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            remain = 8;
            min = 8;
            for (int i = 0; i < 5; i++)
                map[i] = br.readLine().toCharArray();
            sol(0);
            sb.append(remain).append(" ").append(min).append("\n");
            if (N > 0) br.readLine();
        }
        System.out.println(sb);
    }

    static void sol(int cnt) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 'o') {
                    for (int k = 0; k < 4; k++) {
                        if (canMove(i, j, k)) {
                            flag = true;
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            map[ny][nx] = '.';
                            map[ny + dy[k]][nx + dx[k]] = 'o';
                            map[i][j] = '.';
                            sol(cnt + 1);
                            map[ny][nx] = 'o';
                            map[i][j] = 'o';
                            map[ny + dy[k]][nx + dx[k]] = '.';
                        }
                    }
                }
            }
        }
        if (!flag) {
            int pin = 0;
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 9; j++)
                    if (map[i][j] == 'o') pin++;
            if (remain > pin) {
                remain = pin;
                min = cnt;
            } else if (remain == pin && min > cnt) min = cnt;
        }
    }

    // 이동시킬 핀, 방향
    static boolean canMove(int y, int x, int i) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= 5 || nx < 0 || nx >= 9 || map[ny][nx] != 'o') return false;
        ny += dy[i];
        nx += dx[i];
        return ny >= 0 && ny < 5 && nx >= 0 && nx < 9 && map[ny][nx] == '.';
    }
}
