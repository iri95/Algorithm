package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12931_두배더하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            int count1 = k > 0 ? 1 : 0;
            int count2 = 0;
            while (k > 1) {
                if (k % 2 == 1) count1++;
                count2++;
                k /= 2;
            }
            ans += count1;
            maxCnt = Math.max(maxCnt, count2);
        }
        System.out.println(ans + maxCnt);
    }
}
