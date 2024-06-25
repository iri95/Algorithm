package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16432_떡장수와호랑이 {
    static int N;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1][10];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        if (dfs(1, 0)) System.out.println(sb);
        else System.out.println(-1);
    }

    static boolean dfs(int day, int before) {
        if (day > N) {
            for (int i = 0; i < N; i++)  sb.append(answer.get(i)).append("\n");
            return true;
        }
        for (int now : list[day]) {
            if (now == before || visited[day][now]) continue;
            visited[day][now] = true;
            answer.add(now);
            if (dfs(day + 1, now)) return true;
            else answer.remove(day - 1);
        }
        return false;
    }
}
