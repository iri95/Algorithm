package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2617_구슬찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int mid = (N + 1) / 2;
        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int high = Integer.parseInt(st.nextToken());
            int low = Integer.parseInt(st.nextToken());
            map[low][high] = 1;
            map[high][low] = -1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                for (int k = 1; k <= N; k++) {
                    if (k == j || k == i) continue;
                    if(map[j][i] == map[i][k] && map[j][k] == 0) map[j][k] = map[j][i];
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int h = 0;
            int l = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (map[i][j] == 1) h++;
                if (map[i][j] == -1) l++;
            }
            if (h >= mid || l >= mid) answer++;
        }
        System.out.println(answer);
    }
}
