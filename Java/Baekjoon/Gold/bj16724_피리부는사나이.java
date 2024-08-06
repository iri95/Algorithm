package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16724_피리부는사나이 {
    static int N, M;
    static int[] parents;
    static char[] map;
    static Map<Character, Integer> dir = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dir.put('D', M);
        dir.put('U', -M);
        dir.put('L', -1);
        dir.put('R', 1);
        map = new char[N * M];
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < M; j++)
                map[i * M + j] = a.charAt(j);
        }
        parents = new int[N * M];
        for (int i = 0; i < N * M; i++) parents[i] = i;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int a = i * M + j;
                int b = a + dir.get(map[a]);
                union(a, b);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                set.add(findParents(i * M + j));

        System.out.println(set.size());
    }

    private static int findParents(int child) {
        if (parents[child] == child) return child;
        return parents[child] = findParents(parents[child]);
    }

    private static void union(int y, int x) {
        int yp = findParents(y);
        int xp = findParents(x);

        if (yp > xp) parents[yp] = xp;
        else parents[xp] = yp;
    }
}