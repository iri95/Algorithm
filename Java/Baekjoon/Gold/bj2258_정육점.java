package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2258_정육점 {
    private static class Meet implements Comparable<Meet> {
        int gram, cost;

        public Meet(int gram, int cost) {
            this.gram = gram;
            this.cost = cost;
        }

        public int compareTo(Meet m) {
            if (this.cost == m.cost) return m.gram - this.gram;
            return this.cost - m.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 이전의 모든 고기를 더하고 추가로 필요한 고기가 같은 비용의 고기인 경우.
        // 같은 금액의 고기가 3개 이상일 때 다음 비용의 고기를 사면 더 싼 경우.
        Meet[] meets = new Meet[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meets[i] = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meets);
        int sum = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            sum += meets[i].gram;
            int cost = meets[i].cost;
            if (sum >= M) min = Math.min(min, cost);
            while (i + 1 < N && meets[i + 1].cost == meets[i].cost) {
                i++;
                sum += meets[i].gram;
                cost += meets[i].cost;
                if (sum >= M) min = Math.min(min, cost);
            }
        }
        if (min == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}
