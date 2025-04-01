package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20304_비밀번호제작 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int len = (int) Math.floor(Math.log(N) / Math.log(2)); // 최대 안전 거리
        int[] count = new int[N + 1];
        Arrays.fill(count, -1);
        Queue<Integer> q = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int p = Integer.parseInt(st.nextToken());
            q.add(p);
            count[p] = 0;
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i <= len; i++) {
                int k = cur ^ (1 << i);

                if (k > N || count[k] != -1) continue;

                q.add(k);
                count[k] = count[cur] + 1;
                answer = Math.max(answer, count[k]);
            }
        }

        System.out.println(answer);
    }
}
