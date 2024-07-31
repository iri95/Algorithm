package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15732_도토리숨기기 {
    static int N, D;
    static int[][] roles;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        roles = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                roles[i][j] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 1_000_000;
        while (s < e) {
            int mid = (s + e) / 2;
            if (binary(mid)) e = mid;
            else s = mid + 1;
        }
        System.out.println(e);
    }

    private static boolean binary(int n) {
        long count = 0;
        for (int[] r : roles) {
            if (r[0] > n) continue;
            int end = Math.min(r[1], n);
            long cnt = (end - r[0]) / r[2] + 1;
            count += cnt;
        }
        return D <= count;
    }
}
