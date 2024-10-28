package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class bj1029_그림교환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) cost[i][j] = str.charAt(j) - '0';
        }
        int[][] dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], 10);
        dp[0][1] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 1});
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            while (size-- > 0) {
                int[] p = q.poll();
                for(int i = 0; i < N; i++){
                    if(i == p[0] || (p[1] & 1 << i) > 0) continue;
                    int bit = p[1] | 1 << i;
                    if (dp[p[0]][p[1]] > cost[p[0]][i]) continue;
                    if (dp[i][bit] == 10) q.add(new int[]{i, bit});
                    dp[i][bit] = Math.min(dp[i][bit], cost[p[0]][i]);
                }
            }
        }
        System.out.println(count);
    }
}
