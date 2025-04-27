package lv3;

import java.util.*;

public class 모두0으로만들기 {
    static long answer = 0;
    static long[] count;
    static List<Integer>[] list;

    public long solution(int[] a, int[][] edges) {
        int sum = 0;
        boolean flag = true;
        count = new long[a.length];
        list = new ArrayList[a.length];

        for (int i = 0; i < a.length; i++) {
            list[i] = new ArrayList<>();
            sum += a[i];
            count[i] = a[i];
            if (a[i] != 0) flag = false;
        }

        if (sum != 0) return -1;
        if (flag) return 0;

        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        sol(0, -1);
        return answer;
    }

    private static long sol(int n, int pre) {
        if (list[n].size() == 1 && list[n].get(0) == pre)
            return count[n];

        int size = list[n].size();

        for (int i = 0; i < size; i++) {
            int next = list[n].get(i);
            if (next == pre) continue;
            long cnt = sol(next, n);
            count[n] += cnt;
            answer += Math.abs(cnt);
            count[next] = 0;
        }

        return count[n];
    }
}
