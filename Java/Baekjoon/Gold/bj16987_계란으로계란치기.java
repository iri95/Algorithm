package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16987_계란으로계란치기 {
    private static class Egg {
        int S, W;

        Egg(int s, int w) {
            this.S = s;
            this.W = w;
        }
    }

    static int N, answer = 0;
    static Egg[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Egg[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sol(0, 0);
        System.out.println(answer);
    }

    private static void sol(int n, int cnt) {
        if (n == N || cnt == N - 1) {
            answer = Math.max(answer, cnt);
            return;
        }

        if (arr[n].S <= 0) {
            sol(n + 1, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i].S <= 0 || i == n) continue;
            arr[n].S -= arr[i].W;
            arr[i].S -= arr[n].W;
            sol(n + 1, cnt + (arr[n].S <= 0 ? 1 : 0) + (arr[i].S <= 0 ? 1 : 0));
            arr[n].S += arr[i].W;
            arr[i].S += arr[n].W;
        }
    }
}
