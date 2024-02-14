package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13460_구슬탈출2 {
    static int N, M;
    static int ans = 11;
    static Queue<char[][]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int[] R;
        int[] B;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') R = new int[]{i, j};
                if (map[i][j] == 'B') B = new int[]{i, j};
            }
        }
        queue.add(map);
        int count = 1;
        while (count <= 10) {
            int size = queue.size();
            while (size-- > 0) {
                char[][] c = queue.poll();
                char[][] l = left(c);
                char[][] r = right(c);
                char[][] d = down(c);
                char[][] u = up(c);

                if (l[0][0] != 'X') {
                    if (l[0][1] == 'X') ans = count;
                    queue.add(l);
                }
                if (r[0][0] != 'X') {
                    if (r[0][1] == 'X') ans = count;
                    queue.add(r);
                }
                if (d[0][0] != 'X') {
                    if (d[0][1] == 'X') ans = count;
                    queue.add(d);
                }
                if (u[0][0] != 'X') {
                    if (u[0][1] == 'X') ans = count;
                    queue.add(u);
                }
            }
            if (ans != 11) {
                System.out.println(ans);
                return;
            }
            count++;
        }
        System.out.println(-1);
    }

    // ., O 면 이동가능
    static char[][] left(char[][] c) {
        char[][] map = copy(c);
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (map[i][j] == 'R' || map[i][j] == 'B') {
                    int k = j;
                    while (k > 1) {
                        if (map[i][k - 1] != '.' && map[i][k - 1] != 'O') break;
                        if (map[i][k - 1] == 'O') {
                            if (map[i][k] == 'B') map[0][0] = 'X';
                            if (map[i][k] == 'R') {
                                map[0][1] = 'X';
                                map[i][k] = '.';
                            }
                        }
                        if (map[i][k - 1] == '.') {
                            map[i][k - 1] = map[i][k];
                            map[i][k] = '.';
                        }
                        k--;
                    }
                }
            }
        }
        return map;
    }

    static char[][] right(char[][] c) {
        char[][] map = copy(c);
        for (int i = 1; i < N - 1; i++) {
            for (int j = M - 2; j > 0; j--) {
                if (map[i][j] == 'R' || map[i][j] == 'B') {
                    int k = j;
                    while (k < M - 2) {
                        if (map[i][k + 1] != '.' && map[i][k + 1] != 'O') break;
                        if (map[i][k + 1] == 'O') {
                            if (map[i][k] == 'B') map[0][0] = 'X';
                            if (map[i][k] == 'R') {
                                map[0][1] = 'X';
                                map[i][k] = '.';
                            }
                        }
                        if (map[i][k + 1] == '.') {
                            map[i][k + 1] = map[i][k];
                            map[i][k] = '.';
                        }
                        k++;
                    }
                }
            }
        }
        return map;
    }

    static char[][] down(char[][] c) {
        char[][] map = copy(c);
        for (int i = 1; i < M - 1; i++) {
            for (int j = N - 2; j > 0; j--) {
                if (map[j][i] == 'R' || map[j][i] == 'B') {
                    int k = j;
                    while (k < N - 2) {
                        if (map[k + 1][i] != '.' && map[k + 1][i] != 'O') break;
                        if (map[k + 1][i] == 'O') {
                            if (map[k][i] == 'B') map[0][0] = 'X';
                            if (map[k][i] == 'R') {
                                map[0][1] = 'X';
                                map[k][i] = '.';
                            }
                        }
                        if (map[k + 1][i] == '.') {
                            map[k + 1][i] = map[k][i];
                            map[k][i] = '.';
                        }
                        k++;
                    }
                }
            }
        }
        return map;
    }

    static char[][] up(char[][] c) {
        char[][] map = copy(c);
        for (int i = 1; i < M - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[j][i] == 'R' || map[j][i] == 'B') {
                    int k = j;
                    while (k > 1) {
                        if (map[k - 1][i] != '.' && map[k - 1][i] != 'O') break;
                        if (map[k - 1][i] == 'O') {
                            if (map[k][i] == 'B') map[0][0] = 'X';
                            if (map[k][i] == 'R') {
                                map[0][1] = 'X';
                                map[k][i] = '.';
                            }
                        }
                        if (map[k - 1][i] == '.') {
                            map[k - 1][i] = map[k][i];
                            map[k][i] = '.';
                        }
                        k--;
                    }
                }
            }
        }
        return map;
    }

    static char[][] copy(char[][] c) {
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = c[i].clone();
        }
        return map;
    }

}
