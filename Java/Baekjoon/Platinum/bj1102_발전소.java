package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1102_발전소 {
    static int N, P;
    static int[] values;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int INF = Integer.MAX_VALUE;
        map = new int[N][N];
        values = new int[1 << N]; // 해당 index의 발전소를 조건에 해당하는 상태로 만들기 위한 최소 비용
        visited = new boolean[1 << N];
        Arrays.fill(values, INF);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        char[] str = br.readLine().toCharArray();
        P = Integer.parseInt(br.readLine());
        int cnt = 0;
        int s = 0;
        for (int i = 0; i < N; i++) {
            if (str[i] == 'Y') {
                cnt++;
                s += 1 << i;
            }
        }
        if (P <= cnt) {
            System.out.println(0);
            return;
        }
        if (cnt == 0) {
            System.out.println(-1);
            return;
        }
        sol(s, cnt);
        System.out.println(values[s]);

    }

    private static int sol(int value, int p) {
        if (p >= P) return 0;
        if (visited[value]) return values[value];

        for (int i = 0; i < N; i++) {
            if ((value & 1 << i) == 0) continue;
            for (int j = 0; j < N; j++) {
                if ((value & 1 << j) != 0) continue;
                values[value] = Math.min(values[value], sol(value + (1 << j), p + 1) + map[i][j]);
            }
        }
        visited[value] = true;
        return values[value];
    }
}
