package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj3980_선발명단 {
    static class Position {
        int pos;
        int score;

        public Position(int pos, int score) {
            this.pos = pos;
            this.score = score;
        }
    }

    static int ans;
    static boolean[] visited;
    static List<Position>[] S = new ArrayList[11];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            ans = 0;
            visited = new boolean[11];
            for (int i = 0; i < 11; i++) {
                S[i] = new ArrayList<>();
            }
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    if (a > 0) S[i].add(new Position(j, a));
                }
            }
            perm(0, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void perm(int num, int sum) {
        if (num == 11) {
            for (int i = 0; i < 11; i++) if (!visited[i]) return;
            ans = Math.max(ans, sum);
            return;
        }
        for (Position p : S[num]) {
            if (visited[p.pos]) continue;
            visited[p.pos] = true;
            perm(num + 1, sum + p.score);
            visited[p.pos] = false;
        }
    }
}
