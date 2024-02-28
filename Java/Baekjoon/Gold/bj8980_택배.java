package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj8980_택배 {
    static class Boxes implements Comparable<Boxes> {
        int start;
        int end;
        int box;

        public Boxes(int s, int e, int box) {
            this.start = s;
            this.end = e;
            this.box = box;
        }

        @Override
        public int compareTo(Boxes o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        List<Boxes> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Boxes(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        int[] cnt = new int[N + 1];
        Arrays.fill(cnt, C);
        int sum = 0;
        for (int m = 0; m < M; m++) {
            Boxes b = list.get(m);
            int max = b.box;
            for (int i = b.start; i < b.end; i++) {
                if (cnt[i] <= 0) {
                    max = 0;
                    break;
                }
                max = Math.min(cnt[i], max);
            }
            if (max == 0) continue;
            for (int i = b.start; i < b.end; i++) {
                cnt[i] -= max;
            }
            sum += max;
        }
        System.out.println(sum);

    }
}
