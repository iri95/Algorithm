package lv3;

import java.util.*;

public class 순위 {
    private static boolean[] upVisited, downVisited;
    private static List<Integer>[] upList, downList;

    public int solution(int n, int[][] results) {
        int answer = 0;
        upList = new ArrayList[n + 1];
        downList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            upList[i] = new ArrayList<>();
            downList[i] = new ArrayList<>();
        }
        for (int i = 0; i < results.length; i++) {
            upList[results[i][1]].add(results[i][0]);
            downList[results[i][0]].add(results[i][1]);
        }
        for (int i = 1; i <= n; i++) {
            upVisited = new boolean[n + 1];
            downVisited = new boolean[n + 1];
            if (upCount(i) + downCount(i) == n - 1) answer++;
        }
        return answer;
    }

    private static int upCount(int n) {
        if (upVisited[n]) return -1;
        upVisited[n] = true;
        int cnt = 0;
        for (int next : upList[n]) {
            cnt += upCount(next) + 1;
        }
        return cnt;
    }

    private static int downCount(int n) {
        if (downVisited[n]) return -1;
        downVisited[n] = true;
        int cnt = 0;
        for (int next : downList[n]) {
            cnt += downCount(next) + 1;
        }
        return cnt;
    }
}
