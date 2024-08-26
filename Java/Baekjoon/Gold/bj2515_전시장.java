package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2515_전시장 {
    private static class Picture implements Comparable<Picture> {
        int high, cost;

        public Picture(int high, int cost) {
            this.high = high;
            this.cost = cost;
        }

        public int compareTo(Picture p){
            if (this.high == p.high) return p.cost - this.cost;
            return this.high - p.high;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        Picture[] arr = new Picture[N + 1];
        arr[0] = new Picture(0, 0);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Picture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int s = 0;
            int e = i;
            while(s < e){
                int mid = (s + e) / 2;
                if (arr[i].high - arr[mid].high <= S) s = mid + 1;
                else e = mid;
            }
            dp[i] = Math.max(dp[e - 1] + arr[i].cost, dp[i - 1]);
        }
        System.out.println(dp[N]);
    }
}
