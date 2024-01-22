package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25194_결전의금요일 {
    static int N;
    static int[] cnt= new int[7];
    static boolean[] visit;
    static boolean result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken()) % 7;
            if (k == 0) continue;
            cnt[k]++;
        }
        if (cnt[4] != 0) {
            System.out.println("YES");
            return;
        }
        brute(0);
        System.out.println(result ? "YES" : "NO");
    }

    private static void brute(int sum) {
        if (result) return;
        if (sum % 7 == 4) {
            result = true;
            return;
        }
        for (int i = 1; i < 7; i++) {
            if (cnt[i] == 0) continue;
            cnt[i]--;
            brute(sum + i);
            cnt[i]++;
        }
    }
}
