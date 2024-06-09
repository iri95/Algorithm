package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13164_행복유치원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            pq.add(list[i] - list[i - 1]);
        }
        int ans = 0;
        for (int i = 0; i < N - K; i++) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}
