package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2457_공주님의정원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] month = {0, 1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            pq.add(new int[]{month[sm] + sd - 1, month[em] + ed - 2});
        }
        int[] cnt = new int[335];
        int INF = 100_001;
        Arrays.fill(cnt, INF);
        for (int i = 0; i < 60; i++) {
            cnt[i] = 0;
        }
        while (!pq.isEmpty()){
            int[] flowers = pq.poll();
            int s = flowers[0];
            int e = flowers[1];
            int next = cnt[s - 1] + 1;
            for (int j = s; j <= e && j <= 334; j++) {
                cnt[j] = Math.min(cnt[j], next);
            }
        }
        System.out.println(cnt[334] == INF ? 0 : cnt[334]);
    }
}
