package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14890_경사로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int s = 0; s < N; s++) {
            // 행
            int sr = map[s][0];
            boolean can = true;
            boolean[] visit = new boolean[N];
            for (int i = 1; i < N; i++) {
                if (map[s][i] == sr) continue;
                else if (map[s][i] == sr + 1) {
                    for (int j = i - 1; j >= i - L ; j--) {
                        if (j < 0 || visit[j] || map[s][j] != sr) {
                            can = false;
                            break;
                        }
                        visit[j] = true;
                    }
                    sr++;
                } else if (map[s][i] == sr - 1) {
                    for (int j = i; j < i + L; j++) {
                        if (j >= N || visit[j] || map[s][j] != sr - 1) {
                            can = false;
                            break;
                        }
                        visit[j] = true;
                    }
                    sr--;
                }else{
                    can = false;
                    break;
                }
            }
            if (can) answer++;

            // 열
            int sc = map[0][s];
            can = true;
            visit = new boolean[N];
            for (int i = 1; i < N; i++) {
                if (map[i][s] == sc) continue;
                else if (map[i][s] == sc + 1) {
                    for (int j = i - 1; j >= i - L ; j--) {
                        if (j < 0 || visit[j] || map[j][s] != sc) {
                            can = false;
                            break;
                        }
                        visit[j] = true;
                    }
                    sc++;
                } else if (map[i][s] == sc - 1) {
                    for (int j = i; j < i + L; j++) {
                        if (j >= N || visit[j] || map[j][s] != sc - 1) {
                            can = false;
                            break;
                        }
                        visit[j] = true;
                    }
                    sc--;
                }else {
                    can = false;
                    break;
                }
            }
            if (can) answer++;
        }
        System.out.println(answer);
    }
}
