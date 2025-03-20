package lv2;

public class 완점범죄 {
    static int INF = Integer.MAX_VALUE;
    static int answer = INF;
    static boolean[][][] visited;

    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        visited = new boolean[len][n][m];
        dfs(info, 0, 0, 0, len, n, m);
        if (answer == INF) return -1;
        else return answer;
    }

    private static void dfs(int[][] info, int index, int n, int m, int length, int maxN, int maxM) {
        if (index == length) {
            answer = Math.min(answer, n);
            return;
        }

        if (n >= answer || visited[index][n][m]) return;

        visited[index][n][m] = true;
        int nextN = n + info[index][0];
        int nextM = m + info[index][1];

        if (maxN > nextN)
            dfs(info, index + 1, nextN, m, length, maxN, maxM);

        if (maxM > nextM)
            dfs(info, index + 1, n, nextM, length, maxN, maxM);

    }

}
