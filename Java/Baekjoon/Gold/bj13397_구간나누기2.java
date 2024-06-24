package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13397_구간나누기2 {
    static int N, M;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        int e = 0;
        int s = 0;
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            e = Math.max(list[i], e);
        }
        while (s < e) {
            int n = (s + e) / 2;
            if (bfs(n)) e = n;
            else s = n + 1;
        }
        System.out.println(e);
    }

    static boolean bfs(int n) {
        int max = list[1];
        int min = list[1];
        int m = 1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, list[i]);
            min = Math.min(min, list[i]);
            if (max - min > n) {
                m++;
                max = list[i];
                min = list[i];
            }
            if (m > M) return false;
        }
        return true;
    }
}
