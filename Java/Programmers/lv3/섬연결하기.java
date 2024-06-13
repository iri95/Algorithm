package lv3;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        // 비용으로 정렬, 분리집합으로 root를 확인하며 다른 root라면 합치고 비용에 +
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            int p0 = find(costs[i][0]);
            int p1 = find(costs[i][1]);
            if (p0 != p1) {
                answer += costs[i][2];
                set(p0, p1);
            }
        }

        return answer;
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void set(int x, int y) {
        int xP = find(x);
        int yP = find(y);
        if (xP > yP) parent[xP] = yP;
        else parent[yP] = xP;
    }
}
