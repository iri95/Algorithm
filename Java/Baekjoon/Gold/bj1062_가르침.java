package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1062_가르침 {
    static int N, K, ans = 0;
    static int[] list;
    static int teach = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        teach |= 1;
        teach |= (1 << 2);
        teach |= (1 << 8);
        teach |= (1 << 13);
        teach |= (1 << 19);
        // a n t i c
        if (K < 5) {
            System.out.println(0);
            return;
        }
        K -= 5;
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < a.length(); j++) {
                list[i] |= (1 << (a.charAt(j) - 'a'));
            }
        }
        comb(0, 1, teach);
        System.out.println(ans);
    }

    static void comb(int cnt, int next, int bit) {
        if (cnt == K) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if ((list[i] & bit) == list[i]) count++;
            }
            ans = Math.max(ans, count);
            return;
        }

        for (int i = next; i < 26; i++) {
            if ((bit & (1 << i)) >= 1) continue;
            comb(cnt + 1, i + 1, bit | (1 << i));
        }
    }
}
