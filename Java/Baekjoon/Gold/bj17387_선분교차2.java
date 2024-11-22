package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17387_선분교차2 {
    static int ccw(long[] a, long[] b, long[] c) {
        long x = (a[0] * b[1] + b[0] * c[1] + c[0] * a[1]) - (a[1] * b[0] + b[1] * c[0] + c[1] * a[0]);
        if (x > 0) {
            return 1;
        } else if (x == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] p1 = new long[2];
        long[] p2 = new long[2];
        long[] p3 = new long[2];
        long[] p4 = new long[2];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        p1[0] = Integer.parseInt(st1.nextToken());
        p1[1] = Integer.parseInt(st1.nextToken());
        p2[0] = Integer.parseInt(st1.nextToken());
        p2[1] = Integer.parseInt(st1.nextToken());
        p3[0] = Integer.parseInt(st2.nextToken());
        p3[1] = Integer.parseInt(st2.nextToken());
        p4[0] = Integer.parseInt(st2.nextToken());
        p4[1] = Integer.parseInt(st2.nextToken());

        int ccw1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        int ccw2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
        boolean compare1 = Math.min(p1[0], p2[0]) <= Math.max(p3[0], p4[0]);
        boolean compare2 = Math.min(p3[0], p4[0]) <= Math.max(p1[0], p2[0]);
        boolean compare3 = Math.min(p1[1], p2[1]) <= Math.max(p3[1], p4[1]);
        boolean compare4 = Math.min(p3[1], p4[1]) <= Math.max(p1[1], p2[1]);

        if (ccw1 == 0 && ccw2 == 0) {
            if (compare1 && compare2 && compare3 && compare4) System.out.println(1);
            else System.out.println(0);
        } else if (ccw1 <= 0 && ccw2 <= 0) System.out.println(1);
        else System.out.println(0);
    }
}