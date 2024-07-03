package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj14238_출근기록 {
    static int N;
    static int[] count;
    static char[] list;
    static boolean[][][][][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        N = a.length();
        list = new char[N];
        count = new int[3];
        for (int i = 0; i < N; i++) count[a.charAt(i) - 'A']++;
        visited = new boolean[count[0] + 1][count[1] + 1][count[2] + 1][3][3];
        if (perm(0, 0, 0, count[0], count[1], count[2])) System.out.println(sb);
        else System.out.println(-1);
    }

    static boolean perm(int n, int be1, int be2, int a, int b, int c) {
        if (n == N) {
            for (int i = 0; i < N; i++) {
                sb.append(list[i]);
            }
            return true;
        }
        if (visited[a][b][c][be1][be2]) return false;
        visited[a][b][c][be1][be2] = true;
        // C
        if (c > 0 && be1 != 2 && be2 != 2) {
            list[n] = 'C';
            if (perm(n + 1, 2, be1, a, b, c - 1)) return true;
        }

        if (b > 0 && be1 != 1) {
            list[n] = 'B';
            if (perm(n + 1, 1, be1, a, b - 1, c)) return true;
        }

        if (a > 0) {
            list[n] = 'A';
            if (perm(n + 1, 0, be1, a - 1, b, c)) return true;
        }

        return false;
    }

}
