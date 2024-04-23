package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1644_소수의연속합 {
    static int N, cnt;
    static int[] sum;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        visit[0] = visit[1] = true;
        sieve();
        sum = new int[cnt + 1];
        sum[0] = 0;
        cnt = 1;
        for (int i = 2; i <= N; i++) {
            if (visit[i]) continue;
            sum[cnt] = sum[cnt - 1] + i;
            cnt++;
        }
        int answer = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = i + 1; j < cnt; j++) {
                if (sum[j] - sum[i] > N) break;
                if (sum[j] - sum[i] == N) answer++;
            }
        }
        System.out.println(answer);
    }

    static void sieve() {
        cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (visit[i]) continue;
            cnt++;
            for (int j = i * 2; j <= N; j += i) {
                visit[j] = true;
            }
        }
    }
}
