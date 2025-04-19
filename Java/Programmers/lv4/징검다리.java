package lv4;

import java.util.*;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int l = 0;
        int r = distance;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (binary(rocks, mid, n, distance))
                l = mid + 1;
            else
                r = mid - 1;
        }

        return l - 1;
    }

    private static boolean binary(int[] rocks, int m, int n, int dis) {
        int count = 0;
        int start = 0;
        for (int rock : rocks) {
            if (rock - start < m)
                count++;
            else
                start = rock;
        }
        if (dis - start < m) count++;
        return count <= n;
    }
}
