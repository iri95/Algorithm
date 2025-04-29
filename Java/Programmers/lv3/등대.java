package lv3;

import java.util.*;

public class 등대 {
    static int[] link;
    static boolean[] visited;
    static List<Integer>[] list;

    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        link = new int[n + 1];
        Arrays.fill(link, -1);
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int[] path = lighthouse[i];
            list[path[0]].add(path[1]);
            list[path[1]].add(path[0]);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            if (link[i] != -1) continue;
            if (match(i)) answer++;
        }

        return answer;
    }

    private static boolean match(int x) {
        for (int next : list[x]) {
            if (visited[next]) continue;
            visited[next] = true;
            if (link[next] == -1 || match(link[next])) {
                link[next] = x;
                link[x] = next;
                return true;
            }
        }
        return false;
    }
}
