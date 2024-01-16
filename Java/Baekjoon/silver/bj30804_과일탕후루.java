package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj30804_과일탕후루 {
    static int N, max;
    static int[] list, count = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        result(0, 0, 0, 0);
        System.out.println(max);

    }

    public static void result(int a, int b, int kind, int cnt) {
        if (b >= N) return;
        if (count[list[b]] == 0) kind++;
        cnt++;
        count[list[b]]++;
        if (kind > 2) {
            if (--count[list[a]] == 0) kind--;
            cnt--;
            a++;
        }
        max = Math.max(max, cnt);
        result(a, b + 1, kind, cnt);

        return;

    }

}
