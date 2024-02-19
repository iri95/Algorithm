package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-20303-%ED%95%A0%EB%A1%9C%EC%9C%88%EC%9D%98-%EC%96%91%EC%95%84%EC%B9%98-java
public class bj20303_할로윈의양아치 {
    static int[] parent, candy, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        candy = new int[N + 1];
        count = new int[N + 1];
        parent = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            count[i] = 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (i != find(i)) continue;
            if (count[i] >= K) continue;
            list.add(new int[]{count[i], candy[i]});
        }
        int[] dp = new int[K];
        for (int[] p : list) {
            for (int j = K - 1; j >= p[0]; j--) {
                dp[j] = Math.max(dp[j - p[0]] + p[1], dp[j]);
            }
        }
        System.out.println(dp[K - 1]);
    }

    static int find(int n) {
        if (n == parent[n]) return n;
        else return find(parent[n]);
    }

    static void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) return;
        if (xParent < yParent) {
            parent[yParent] = xParent;
            candy[xParent] += candy[yParent];
            count[xParent] += count[yParent];
        } else {
            parent[xParent] = yParent;
            candy[yParent] += candy[xParent];
            count[yParent] += count[xParent];
        }
    }
}
