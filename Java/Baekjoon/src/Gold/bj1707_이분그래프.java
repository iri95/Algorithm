package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// https://loosie.tistory.com/227
public class bj1707_이분그래프 {
    static int v, e;
    static List<Integer>[] list;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new ArrayList[v + 1];
            for (int i = 1; i < v + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }
            color = new int[v + 1];
            isBiGraph(1);
        }
    }
    static void isBiGraph(int start) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < v + 1; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                q.add(i);
            }
            while (!q.isEmpty()) {
                int pos = q.poll();
                for (int next : list[pos]) {
                    if (color[next] == color[pos]) {
                        System.out.println("NO");
                        return;
                    }
                    if (color[next] == 0) {
                        q.add(next);
                        if (color[pos] == 1) {
                            color[next] = 2;
                        } else {
                            color[next] = 1;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
    }
}