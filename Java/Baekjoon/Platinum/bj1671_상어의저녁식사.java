package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1671_상어의저녁식사 {
    private static class Shark {
        int size;
        int v;
        int intel;
        List<Integer> eat = new ArrayList<>();

        public Shark(int size, int v, int intel) {
            this.size = size;
            this.v = v;
            this.intel = intel;
        }

        public int canEat(Shark s) {
            if (this.size >= s.size && this.v >= s.v && this.intel >= s.intel) {
                if (this.size == s.size && this.v == s.v && this.intel == s.intel) return 0;
                return 1;
            }
            else return -1;
        }
    }

    static boolean[] visited;
    static int[] ate;
    static Shark[] sharks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sharks = new Shark[N + 1];
        ate = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int intel = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(size, v, intel);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                int can = sharks[i].canEat(sharks[j]);
                if (can == 1) sharks[i].eat.add(j);
                else if (can == 0 && i > j) sharks[i].eat.add(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= N; j++) {
                visited = new boolean[N + 1];
                if (dfs(j)) ans++;
            }
        }

        System.out.println(N - ans);
    }

    private static boolean dfs(int shark) {
        for (int next : sharks[shark].eat) {
            if (visited[next]) continue;
            visited[next] = true;
            if (ate[next] == 0 || dfs(ate[next])) {
                ate[next] = shark;
                return true;
            }
        }
        return false;
    }
}
