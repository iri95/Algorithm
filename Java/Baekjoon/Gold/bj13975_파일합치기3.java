package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13975_파일합치기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        long K, ans, T = Integer.parseInt(br.readLine());
        Queue<Long> pq = new PriorityQueue<>();
        while (T-- > 0) {
            ans = 0;
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long sum = a + b;
                ans += sum;
                pq.add(sum);
            }
            pq.poll();
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
