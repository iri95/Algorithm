package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17071_숨바꼭질5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int INF = 500_001;
        if (N == k) {
            System.out.println(0);
            return;
        }
        int[] count = new int[INF];
        for (int i = 1; k + i < INF; i++) {
            count[k + i] = i;
            k += i;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        boolean[] visitedEven = new boolean[INF];
        boolean[] visitedOdd = new boolean[INF];
        int cnt = 0;
        int min = INF;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int s = 0; s < size; s++) {
                int n = q.poll();
                for (int i = 0; i < 3; i++) {
                    int next;
                    if (i == 0) next = n - 1;
                    else if (i == 1) next = n + 1;
                    else next = n * 2;
                    if (next < 0 || next > 500_000) continue;
                    if (cnt % 2 == 0) {
                        if (visitedEven[next]) continue;
                        else visitedEven[next] = true;
                    } else {
                        if (visitedOdd[next]) continue;
                        else visitedOdd[next] = true;
                    }
                    if (count[next] != 0 && count[next] >= cnt && (count[next] - cnt) % 2 == 0) {
                        min = Math.min(count[next], min);
                    }
                    q.add(next);
                }
            }
        }
        if (min == INF) System.out.println(-1);
        else System.out.println(min);
    }
}
