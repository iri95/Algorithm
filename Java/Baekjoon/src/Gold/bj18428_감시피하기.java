package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18428_감시피하기 {
    static int N;
    static int[][] obstacle = new int[3][2];
    static boolean result;
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T' || map[i][j] == 'S') {
                    visit[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;
                visit[i][j] = true;
                comb(1, new int[][]{{i, j}, {0, 0}, {0, 0}});
                visit[i][j] = false;
                if (result) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    // 장애물 설치 조함
    static void comb(int obsLen, int[][] obstacle) {
        if (obsLen == 3) {
            if (see(obstacle)) {
                result = true;
            }
            return;
        }
        for (int i = obstacle[obsLen - 1][0]; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;
                visit[i][j] = true;
                obstacle[obsLen][0] = i;
                obstacle[obsLen][1] = j;
                comb(obsLen + 1, obstacle);
                visit[i][j] = false;
            }
        }
    }

    // 선생에게 들키는 경우 return false
    static boolean see(int[][] obstacle) {
        boolean[][] obsMap = new boolean[N][N];
        for (int i = 0; i < 3; i++) {
            obsMap[obstacle[i][0]][obstacle[i][1]] = true;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'T') {
                    for (int k = i + 1; k < N; k++) {
                        if (obsMap[k][j]) break;
                        if (map[k][j] == 'S') return false;
                    }
                    for (int k = i - 1; k >= 0; k--) {
                        if (obsMap[k][j]) break;
                        if (map[k][j] == 'S') return false;
                    }
                    for (int k = j + 1; k < N; k++) {
                        if (obsMap[i][k]) break;
                        if (map[i][k] == 'S') return false;
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (obsMap[i][k]) break;
                        if (map[i][k] == 'S') return false;
                    }
                }
            }
        }
        return true;
    }
}
