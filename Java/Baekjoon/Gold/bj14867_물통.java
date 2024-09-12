package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14867_물통 {
    private static class Bottle {
        int A, B;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bottle bottle = (Bottle) o;
            return A == bottle.A && B == bottle.B;
        }

        @Override
        public int hashCode() {
            return Objects.hash(A, B);
        }

        public Bottle(int a, int b) {
            A = a;
            B = b;
        }
    }
    static Set<Bottle> set = new HashSet<>();
    static Queue<Bottle> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if (c == 0 && d == 0) {
            System.out.println(0);
            return;
        }

        q.add(new Bottle(0, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Bottle bottle = q.poll();
                if (bottle.A == c && bottle.B == d) {
                    System.out.println(ans);
                    return;
                }
                sol(a, bottle.B);
                sol(bottle.A, b);
                sol(0, bottle.B);
                sol(bottle.A, 0);
                int sum = bottle.A + bottle.B;
                if (sum > a) sol(a, sum - a);
                else sol(sum, 0);
                if (sum > b) sol(sum - b, b);
                else sol(0, sum);
            }
            ans++;
        }
        System.out.println(-1);
    }

    private static void sol(int x, int y) {
        if (set.contains(new Bottle(x, y))) return;

        Bottle bottle = new Bottle(x, y);
        q.add(bottle);
        set.add(bottle);
    }
}
