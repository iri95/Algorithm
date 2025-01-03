package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj11014_컨닝2 {
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int[] dy = {-1, 0, 1, -1, 0, 1};
        int[] dx = {-1, -1, -1, 1, 1, 1};

        while (C-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[N][M];
            int max = 0;
            for (int i = 0; i < N; i++) {
                String read = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (read.charAt(j) == '.') {
                        map[i][j] = true;
                        max++;
                    }
                }
            }
            lists = new ArrayList[N * M]; // 세로로 번호를 센다
            for (int i = 0; i < N * M; i++) lists[i] = new ArrayList<>();

            for (int x = 0; x < M; x += 2) { // 열
                for (int y = 0; y < N; y++) { // 행
                    if (!map[y][x]) continue;
                    for (int k = 0; k < 6; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M || !map[ny][nx]) continue;
                        lists[x * N + y].add(nx * N + ny);
                    }
                }
            }

            int cnt = 0;
            parent = new int[N * M];
            Arrays.fill(parent, -1);
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x += 2) {
                    visited = new boolean[N * M];
                    if (dfs(x * N + y)) cnt++;
                }
            }
            System.out.println(max - cnt);
        }
    }

    private static boolean dfs(int node) {
        for (int next : lists[node]) {
            if (visited[next]) continue;
            visited[next] = true;
            if (parent[next] == -1 || dfs(parent[next])) {
                parent[next] = node;
                return true;
            }
        }
        return false;
    }
}
