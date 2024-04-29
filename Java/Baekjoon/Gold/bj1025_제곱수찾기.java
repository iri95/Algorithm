package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1025_제곱수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int ans = -1;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        if (N == 1 && M == 1 && squared(map[0][0] - '0')) ans = map[0][0] - '0';

        for (int ySum = -N + 1; ySum < N; ySum++) {
            for (int xSum = -M + 1; xSum < M; xSum++) {
                if (ySum == 0 && xSum == 0) continue;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int sum = 0;
                        int y = i;
                        int x = j;
                        while (y < N && x < M && y >= 0 && x >= 0) {
                            sum = sum * 10 + (map[y][x] - '0');
                            if (squared(sum))
                                ans = Math.max(ans, sum);
                            y += ySum;
                            x += xSum;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static boolean squared(int n) {
        return Math.sqrt(n) - (int) Math.sqrt(n) == 0;
    }
}
