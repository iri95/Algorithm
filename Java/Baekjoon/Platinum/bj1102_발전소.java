package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1102_발전소 {
    static int N, P, INF = Integer.MAX_VALUE;
    static int[] values;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        values = new int[1 << N]; // 해당 index의 발전소를 조건에 해당하는 상태로 만들기 위한 최소 비용
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
        if (P != 0 && cnt == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sol(s, cnt));
    }

    private static int sol(int value, int p) {
        if (p >= P) return 0;
        if (values[value] != INF) return values[value];

        for (int i = 0; i < N; i++) {
            if ((value & 1 << i) == 0) continue;
            for (int j = 0; j < N; j++) {
                if ((value & 1 << j) != 0) continue;
                values[value] = Math.min(values[value], sol(value + (1 << j), p + 1) + map[i][j]);
            }
        }

        return values[value];
    }
}
