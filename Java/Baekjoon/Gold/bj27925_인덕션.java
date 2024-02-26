package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj27925_인덕션 {
    /*
    한 음식당 최대 5번을 누름, 두 값의 차의 절댓값이 5 이상이면 10 - 절댓값, 이하면 절댓값만큼 눌러야함.
    인덕션은 3개, 3의 5000승은 말이 안됨. -> 모든 경우의 수를 생각하는 건아님.
    재귀로?
     */
    static int N, max = Integer.MAX_VALUE;
    static int[] list;
    static int[][][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N][10][10][10];
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    Arrays.fill(dp[i][j][k], max);
                }
            }
        }
        System.out.println(dfs(0, 0, 0, 0));
    }

    static int dfs(int a, int b, int c, int n) {
        if (n == N) return 0;
        if (dp[n][a][b][c] != max) return dp[n][a][b][c];
        int an = Math.abs(list[n] - a);
        int bn = Math.abs(list[n] - b);
        int cn = Math.abs(list[n] - c);
        an = an > 5 ? 10 - an : an;
        bn = bn > 5 ? 10 - bn : bn;
        cn = cn > 5 ? 10 - cn : cn;
        int k = (int) max;
        k = Math.min(dfs(list[n], b, c, n + 1) + an, k);
        k = Math.min(dfs(a, list[n], c, n + 1) + bn, k);
        k = Math.min(dfs(a, b, list[n], n + 1) + cn, k);
        return dp[n][a][b][c] = k;
    }
}
/* 틀린 풀이
방문 처리를 했지만 그와 같은 경우에 더 작은 값으로 다시 방문할 수도 있기 때문에 틀림.
위의 풀이처럼 더 깊은 값들에서 이미 최솟값을 구해두고 그 값을 리턴해야 함.
static int N, min;
    static int[] list;
    static boolean[][][][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[N][10][10][10];
        min = Integer.MAX_VALUE;
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0, 0, 0);
        System.out.println(min);
    }

    static void dfs(int a, int b, int c, int n, int count) {
        if (n == N) {
            min = Math.min(min, count);
            return;
        }
        if (visit[n][a][b][c]) return;
        visit[n][a][b][c] = true;
        int an = Math.abs(list[n] - a);
        int bn = Math.abs(list[n] - b);
        int cn = Math.abs(list[n] - c);
        an = an > 5 ? 10 - an : an;
        bn = bn > 5 ? 10 - bn : bn;
        cn = cn > 5 ? 10 - cn : cn;
        dfs(list[n], b, c, n + 1, count + an);
        dfs(a, list[n], c, n + 1, count + bn);
        dfs(a, b, list[n], n + 1, count + cn);
    }
 */