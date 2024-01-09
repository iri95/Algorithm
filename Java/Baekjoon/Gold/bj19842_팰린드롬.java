package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19842_팰린드롬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
            int front1 = i - 1;
            int back1 = i + 1;
            int front2 = i;
            int back2 = i + 1;
            while (front1 > 0 && back1 <= N) {
                if (list[front1] == list[back1]) dp[front1][back1] = 1;
                else break;
                front1--;
                back1++;
            }
            while (front2 > 0 && back2 <= N) {
                if (list[front2] == list[back2]) dp[front2][back2] = 1;
                else break;
                front2--;
                back2++;
            }

        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}
