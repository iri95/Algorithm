package lv3;

import java.util.*;

public class 사칙연산 {
    static int INFMAX = -1_000_001, INFMIN = 1_000_101;
    static int[][] dpMax, dpMin;
    static String[] strs;

    public int solution(String arr[]) {
        strs = arr;
        int len = arr.length;
        dpMax = new int[len][len];
        dpMin = new int[len][len];
        for (int i = 0; i < len; i += 2) {
            Arrays.fill(dpMax[i], INFMAX);
            dpMax[i][i] = Integer.parseInt(arr[i]);
            Arrays.fill(dpMin[i], INFMIN);
            dpMin[i][i] = Integer.parseInt(arr[i]);
        }

        for (int i = 1; i < len; i += 2) {
            int l = Integer.parseInt(arr[i - 1]);
            int r = Integer.parseInt(arr[i + 1]);

            if (arr[i].equals("+")) {
                dpMax[i - 1][i + 1] = l + r;
                dpMin[i - 1][i + 1] = l + r;
            } else {
                dpMax[i - 1][i + 1] = l - r;
                dpMin[i - 1][i + 1] = l - r;
            }
        }

        return max(0, len - 1);
    }

    private static int max(int l, int r) {
        if (dpMax[l][r] != INFMAX) return dpMax[l][r];
        for (int i = l + 1; i < r; i += 2) {
            if (strs[i].equals("+"))
                dpMax[l][r] = Math.max(dpMax[l][r], max(l, i - 1) + max(i + 1, r));
            else
                dpMax[l][r] = Math.max(dpMax[l][r], max(l, i - 1) - min(i + 1, r));
        }
        return dpMax[l][r];
    }

    private static int min(int l, int r) {
        if (dpMin[l][r] != INFMIN) return dpMin[l][r];

        for (int i = l + 1; i < r; i += 2) {
            if (strs[i].equals("+"))
                dpMin[l][r] = Math.min(dpMin[l][r], min(l, i - 1) + min(i + 1, r));
            else
                dpMin[l][r] = Math.min(dpMin[l][r], min(l, i - 1) - max(i + 1, r));
        }
        return dpMin[l][r];
    }
}
