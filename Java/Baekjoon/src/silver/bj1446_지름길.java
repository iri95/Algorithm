package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj1446_지름길 {
    public static class Fast implements Comparable<Fast> {
        int start;
        int end;
        int meter;

        public Fast(int start, int end, int meter) {
            this.start = start;
            this.end = end;
            this.meter = meter;
        }

        @Override
        public int compareTo(Fast o) {
            return this.start - o.start == 0 ? this.end - o.end == 0 ? this.meter - o.meter : this.end - o.end : this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        List<Fast> fasts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            fasts.add(new Fast(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(fasts);
        int[] route = new int[10001];
        for (int i = 1; i < 10001; i++) {
            for (Fast fast : fasts
            ) {
                if (route[i] == 0) {
                    if (i == fast.end) {
                        route[i] = Math.min(route[i - 1] + 1, route[fast.start] + fast.meter);
                    } else {
                        route[i] = route[i - 1] + 1;
                    }
                } else {
                    if (i == fast.end) {
                        route[i] = Math.min(route[i], route[fast.start] + fast.meter);
                    }
                }

            }
        }
        System.out.println(route[D]);
    }
}
