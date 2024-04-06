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
        int[][] highMap = new int[N + 1][N + 1];
        int[][] lowMap = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int high = Integer.parseInt(st.nextToken());
            int low = Integer.parseInt(st.nextToken());
            highMap[low][high] = 1;
            lowMap[high][low] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                for (int k = 1; k <= N; k++) {
                    if (k == j || k == i) continue;
                    if (highMap[j][i] > 0 && highMap[i][k] > 0) {
                        highMap[j][k] = 1;
                    }
                    if (lowMap[j][i] > 0 && lowMap[i][k] > 0) {
                        lowMap[j][k] = 1;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int h = 0;
            int l = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (highMap[i][j] > 0) h++;
                if (lowMap[i][j] > 0) l++;
            }
            if (h >= mid || l >= mid) answer++;
        }
        System.out.println(answer);
    }
}
