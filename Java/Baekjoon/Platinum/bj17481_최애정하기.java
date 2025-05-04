package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj17481_최애정하기 {
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();
    static List<String>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++)
            map.put(br.readLine(), -1);

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++)
                lists[i].add(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            if (matching(i))
                count++;
        }

        if (count == N)
            System.out.println("YES");
        else
            System.out.println("NO\n" + count);

    }

    private static boolean matching(int n) {
        if (visited[n]) return false;
        visited[n] = true;
        for (String name : lists[n]) {
            if (map.get(name) == -1 || matching(map.get(name))) {
                map.put(name, n);
                return true;
            }
        }

        return false;
    }
}
