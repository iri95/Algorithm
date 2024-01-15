package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16197_두동전 {
    static int N, M;
    static Queue<int[]> coin1 = new ArrayDeque<>();
    static Queue<int[]> coin2 = new ArrayDeque<>();
    static char[][] map;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        boolean cnt = false;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'o') {
                    if (!cnt) {
                        coin1.add(new int[]{i, j});
                        cnt = !cnt;
                    } else {
                        coin2.add(new int[]{i, j});
                        cnt = !cnt;
                    }

                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        int count = 0;
        while (count < 10) {
            count++;
            int size = coin1.size();
            while (size-- > 0) {
                int[] c1 = coin1.poll();
                int[] c2 = coin2.poll();
                for (int i = 0; i < 4; i++) {
                    int ny1 = c1[0] + dy[i];
                    int ny2 = c2[0] + dy[i];
                    int nx1 = c1[1] + dx[i];
                    int nx2 = c2[1] + dx[i];
                    if ((ny1 < 0 || ny1 >= N || nx1 < 0 || nx1 >= M) && (ny2 < 0 || ny2 >= N || nx2 < 0 || nx2 >= M))
                        continue;
                    if (ny1 < 0 || ny1 >= N || nx1 < 0 || nx1 >= M || ny2 < 0 || ny2 >= N || nx2 < 0 || nx2 >= M)
                        return count;
                    if (map[ny1][nx1] == '#') coin1.add(new int[]{c1[0], c1[1]});
                    else coin1.add(new int[]{ny1, nx1});
                    if (map[ny2][nx2] == '#') coin2.add(new int[]{c2[0], c2[1]});
                    else coin2.add(new int[]{ny2, nx2});
                }
            }
        }
        return -1;
    }
}
