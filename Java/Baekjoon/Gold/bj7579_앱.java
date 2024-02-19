package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj7579_앱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] dp = new int[M + 1];
        int Max = Integer.MAX_VALUE;
        Arrays.fill(dp, Max);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            int memory = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            for (int j = M; j >= 0; j--) {
                if (dp[j] != Max) {
                    if (j + memory > M) {
                        dp[M] = Math.min(dp[j] + c, dp[M]);
                    }else{
                        dp[j + memory] = Math.min(dp[j] + c, dp[j + memory]);
                    }
                }
            }
        }
        System.out.println(dp[M]);
    }
}

/*
좋은 풀이
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_MEMORY = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringTokenizer bites = new StringTokenizer(br.readLine());
        StringTokenizer costs = new StringTokenizer(br.readLine());
        int[] dp = new int[MAX_MEMORY];
        int index = 0;
        for (int n = 0; n < N; n++) {
            int bite = Integer.parseInt(bites.nextToken());
            int cost = Integer.parseInt(costs.nextToken());
            if (cost == 0) {
                M -= bite;
                continue;
            }
            for (int i = index; i > 0; i--) {
                if (dp[i] != 0) dp[i + cost] = Math.max(dp[i + cost], dp[i] + bite);
            }
            dp[cost] = Math.max(dp[cost], bite);
            index += cost;
        }
        for (int i = 0; i < MAX_MEMORY; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
 */
