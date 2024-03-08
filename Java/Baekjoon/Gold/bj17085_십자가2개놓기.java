package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj17085_십자가2개놓기 {
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#') list.add(new int[]{i, j});
            }
        }
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer = Math.max(answer, size(list.get(i)[0], list.get(i)[1]));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int y1 = list.get(i)[0];
                int x1 = list.get(i)[1];
                int y2 = list.get(j)[0];
                int x2 = list.get(j)[1];
                int size = 0;
                while (true) {
                    map[y1][x1] = '.';
                    answer = Math.max(answer, (size * 4 + 1) * size(y2, x2));
                    size++;
                    if (y1 - size < 0 || map[y1 - size][x1] == '.') break;
                    if (y1 + size >= N || map[y1 + size][x1] == '.') break;
                    if (x1 - size < 0 || map[y1][x1 - size] == '.') break;
                    if (x1 + size >= M || map[y1][x1 + size] == '.') break;
                    for (int k = 0; k < 4; k++) {
                        map[y1 + dy[k] * size][x1 + dx[k] * size] = '.';
                    }
                }
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < 4; l++) {
                        map[y1 + dy[l] * k][x1 + dx[l] * k] = '#';
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static int size(int y, int x) {
        if (map[y][x] == '.') return 0;
        int[] size = new int[4];
        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;
            while (true) {
                ny += dy[i];
                nx += dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == '.') break;
                size[i]++;
            }
        }
        int answer = 15;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, size[i]);
        }
        return answer * 4 + 1;
    }
}
