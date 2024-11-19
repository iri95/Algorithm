package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1043_거짓말 {
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        List<Integer>[] lists = new ArrayList[M];
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int i = 0; i < a; i++) parents[Integer.parseInt(st.nextToken())] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            lists[i] = new ArrayList<>();
            a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) lists[i].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++)
            for (int x : lists[i])
                for (int y : lists[i])
                    union(x, y);

        int cnt = M;
        for (int i = 0; i < M; i++) {
            for (int n: lists[i]) {
                if (find(n) == 0) {
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int find(int n) {
        if (parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    private static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);

        if (xp < yp) parents[yp] = xp;
        else parents[xp] = yp;
    }
}
