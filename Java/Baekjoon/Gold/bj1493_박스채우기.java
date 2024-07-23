package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1493_박스채우기 {
    static long[] need = new long[20];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int min = Math.min(Math.min(l, w), h);
        setNeed(l, w, h, min);
        int N = Integer.parseInt(br.readLine());
        long[] count = new long[20];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            count[Integer.parseInt(st.nextToken())] = Long.parseLong(st.nextToken());
        }
        long ans = 0;
        for (int i = 19; i > 0; i--) {
            if (need[i] > count[i]) {
                need[i] -= count[i];
                ans += count[i];
                need[i - 1] += need[i] * 8;
            } else {
                ans += need[i];
                need[i] = 0;
            }
        }
        if (need[0] > count[0]) System.out.println(-1);
        else System.out.println(ans + need[0]);

    }

    static void setNeed(int l, int w, int h, int max) {
        if (max == 0) return;
        int index = 19;
        while (Math.pow(2, index) > max) index--;
        int len = (int) Math.pow(2, index);
        if (l >= len && w >= len && h >= len) need[index] += (long) (l / len) * (w / len) * (h / len);
        int lLen = (l / len) * len;
        int wLen = (w / len) * len;
        int hLen = (h / len) * len;
        int nl = l % len;
        int nw = w % len;
        int nh = h % len;
        setNeed(lLen, wLen, nh, nh);
        setNeed(lLen, nw, hLen, nw);
        setNeed(nl, wLen, hLen, nl);
        setNeed(lLen, nw, nh, Math.min(nw, nh));
        setNeed(nl, nw, hLen, Math.min(nl, nw));
        setNeed(nl, wLen, nh, Math.min(nl, nh));
        setNeed(nl, nw, nh, Math.min(Math.min(nl, nw), nh));
    }


}
