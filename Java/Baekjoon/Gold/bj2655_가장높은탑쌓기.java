package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2655_가장높은탑쌓기 {
    static class Stone implements Comparable<Stone> {
        int number;
        int area;
        int length;
        int weight;

        public Stone(int number, int area, int length, int weight) {
            this.number = number;
            this.area = area;
            this.length = length;
            this.weight = weight;
        }

        public int compareTo(Stone o) {
            return o.area - this.area;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stone[] stones = new Stone[N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            stones[i - 1] = new Stone(i, area, length, weight);
        }
        Arrays.sort(stones);
        int[][] dp = new int[N][3];
        dp[0][0] = stones[0].length;
        dp[0][1] = -1;
        dp[0][2] = 1;
        int index = 0;
        int max = stones[0].length;
        for (int i = 1; i < N; i++) {
            dp[i][0] = stones[i].length;
            dp[i][1] = -1;
            dp[i][2] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (stones[i].weight < stones[j].weight) {
                    if (dp[j][0] + stones[i].length > dp[i][0]) {
                        dp[i][0] = dp[j][0] + stones[i].length;
                        dp[i][1] = j;
                        dp[i][2] = dp[j][2] + 1;
                    }
                }
            }
            if (max < dp[i][0]) {
                max = dp[i][0];
                index = i;
            }
        }
        sb.append(dp[index][2]).append("\n");
        while (index >= 0) {
            sb.append(stones[index].number).append("\n");
            index = dp[index][1];
        }
        System.out.println(sb);
    }
}
