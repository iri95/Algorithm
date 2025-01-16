package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2618_경찰차 {
    static int N, W;
    static int[][] dp, point;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        point = new int[W + 1][2];
        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[W + 1][W + 1];
        StringBuilder sb = new StringBuilder();
        sb.append(topdown(1, 0, 0)).append("\n");

        int left = 0;
        int right = 0;
        for (int i = 1; i <= W; i++) {
            int leftCount = distance(1, left, i);
            if (leftCount == dp[left][right] - dp[i][right]) {
                sb.append(1).append("\n");
                left = i;
            }
            else {
                right = i;
                sb.append(2).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int topdown(int index, int left, int right) {
        if (index > W) return 0;

        if (dp[left][right] != 0) return dp[left][right];

        int leftCount = topdown(index + 1, index, right) + distance(1, left, index);
        int rightCount = topdown(index + 1, left, index) + distance(2, right, index);

        return dp[left][right] = Math.min(leftCount, rightCount);
    }

    private static int distance(int type, int start, int end) {
        if (start == 0) {
            if (type == 1) return point[end][0] + point[end][1] - 2;
            else return 2 * N - point[end][0] - point[end][1];
        } else return Math.abs(point[start][0] - point[end][0]) + Math.abs(point[start][1] - point[end][1]);

    }
}