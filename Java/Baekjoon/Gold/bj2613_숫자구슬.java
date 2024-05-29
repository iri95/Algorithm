package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2613_숫자구슬 {
    static int N, M;
    static int[] prefix;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefix = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        int s = 0;
        for (int i = 1; i <= N; i++) {
            int bead = Integer.parseInt(st.nextToken());
            s = Math.max(bead, s);
            prefix[i] = prefix[i - 1] + bead;
        }
        s--;
        int e = prefix[N];
        while (s < e) {
            int m = (s + e) / 2;
            if (isMin(m)) e = m;
            else s = m + 1;
        }
        System.out.println(e);
        System.out.println(sb);
    }

    static boolean isMin(int value) {
        StringBuilder a = new StringBuilder();
        int group = M;
        int start, end = 0;
        while (group > 0) {
            start = end;
            for (int i = start + 1; i <= N - group + 1; i++) {
                if (prefix[i] - prefix[start] > value) break;
                else end = i;
            }
            a.append(end - start).append(" ");
            group--;
        }
        if (end < N)
            return false;

        sb = a;
        return true;
    }
}
