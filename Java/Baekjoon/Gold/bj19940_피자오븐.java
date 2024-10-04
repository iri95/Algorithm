package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class bj19940_피자오븐 {
    public static void main(String[] args) throws Exception {
        int[][] arr = new int[61][5];
        int[] next = {60, 10, -10, 1, -1};
        boolean[] visited = new boolean[61];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i = 4; i >= 0; i--) {
                int np = p + next[i];
                if (np < 0 || np > 60 || visited[np]) continue;
                visited[np] = true;
                for (int j = 0; j < 5; j++)arr[np][j] = arr[p][j];
                arr[np][i]++;
                q.add(np);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int a = Integer.parseInt(br.readLine());
            int[] ans = new int[5];
            ans[0] = a / 60;
            a %= 60;
            for (int i = 0; i < 5; i++) ans[i] += arr[a][i];
            for (int i = 0; i < 5; i++) sb.append(ans[i]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
