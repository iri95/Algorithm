package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16397_탈출 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int INF = 100_000;
        boolean[] visited = new boolean[100_000];
        visited[N] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        int count = 0;
        while (!q.isEmpty() && count <= T) {
            int size = q.size();
            while (size-- > 0) {
                int n = q.poll();
                if (n == G) {
                    System.out.println(count);
                    return;
                }
                if (n + 1 >= INF) continue;
                if (!visited[n + 1]) {
                    visited[n + 1] = true;
                    q.add(n + 1);
                }

                int next = n * 2;
                if (next > 99999) continue;
                else if (next > 9999) next -= 10000;
                else if (next > 999) next -= 1000;
                else if (next > 99) next -= 100;
                else if (next > 9) next -= 10;
                else next--;

                if (next < 0) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
            count++;
        }
        System.out.println("ANG");
    }
}
