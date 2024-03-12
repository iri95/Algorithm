package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19942_다이어트 {
    static class Food {
        int p;
        int f;
        int s;
        int u;
        int price;

        public Food(int p, int f, int s, int u, int price) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.u = u;
            this.price = price;
        }
    }

    static int N, mp, mf, ms, mu, answer;
    static StringBuilder answerSb = new StringBuilder();
    static boolean[] visit;
    static Food[] foods;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mu = Integer.parseInt(st.nextToken());
        foods = new Food[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            answer += foods[i].price;
        }
        answer++;
        subset(1, 0, 0, 0, 0, 0);
        if (answerSb.length() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
        System.out.println(answerSb);
    }

    static void subset(int index, int pSum, int fSum, int sSum, int uSum, int priceSum) {
        if (priceSum >= answer) return;
        if (pSum >= mp && fSum >= mf && sSum >= ms && uSum >= mu) {
            answer = Math.min(answer, priceSum);
            answerSb.delete(0, answerSb.length());
            for (int i = 1; i <= N; i++) {
                if (visit[i])
                    answerSb.append(i).append(" ");
            }
            return;
        }
        if (index > N) return;
        visit[index] = true;
        subset(index + 1, pSum + foods[index].p, fSum + foods[index].f, sSum + foods[index].s, uSum + foods[index].u, priceSum + foods[index].price);
        visit[index] = false;
        subset(index + 1, pSum, fSum, sSum, uSum, priceSum);
    }
}
