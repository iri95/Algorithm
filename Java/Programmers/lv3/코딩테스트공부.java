package lv3;

import java.util.*;

public class 코딩테스트공부 {
    static int al, co, INF = 30_001;
    static int[][] dp;

    public int solution(int alp, int cop, int[][] problems) {
        al = alp;
        co = cop;

        for (int[] problem : problems) {
            al = Math.max(al, problem[0]);
            co = Math.max(co, problem[1]);
        }

        dp = new int[al + 1][co + 1];
        for (int i = 0; i <= al; i++)
            Arrays.fill(dp[i], INF);

        return sol(alp, cop, problems);
    }

    private static int sol(int a, int c, int[][] problems) {
        if (a > al) a = al;
        if (c > co) c = co;

        if (a == al && c == co)
            return 0;

        if (dp[a][c] != INF)
            return dp[a][c];

        if (a == al) dp[a][c] = sol(a, c + 1, problems) + 1;
        else if (c == co) dp[a][c] = sol(a + 1, c, problems) + 1;
        else dp[a][c] = Math.min(sol(a, c + 1, problems) + 1, sol(a + 1, c, problems) + 1);

        for (int[] p : problems) {
            if (p[0] > a || p[1] > c) continue;
            dp[a][c] = Math.min(dp[a][c], sol(a + p[2], c + p[3], problems) + p[4]);
        }

        return dp[a][c];
    }
}
