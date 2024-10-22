package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj9460_메탈 {
    private static class Metal implements Comparable<Metal> {
        double y, x;

        public Metal(double y, double x) {
            this.y = y;
            this.x = x;
        }

        public int compareTo(Metal t) {
            return Double.compare(this.x, t.x);
        }
    }

    static int n, k;
    static Metal[] metals;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            metals = new Metal[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                metals[i] = new Metal(y, x);
            }
            Arrays.sort(metals);
            double s = 0;
            double e = 100_000_001;
            while (e - s > 0.01) {
                double m = (s + e) / 2;
                if (can(m)) e = Math.floor(m * 100) / 100;
                else s = m + 0.01;
            }
            sb.append(String.format("%.1f", e)).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean can(double d) {
        double min = 100_000_001;
        double max = -100_000_001;
        int kCnt = 1;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, metals[i].y);
            max = Math.max(max, metals[i].y);
            if (d < (max - min) / 2) {
                kCnt++;
                max = metals[i].y;
                min = metals[i].y;
            }
            if (kCnt > k) return false;
        }
        return true;
    }
}
