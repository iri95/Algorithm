package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16940_BFS스페셜저지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer>[] lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lists[s].add(e);
            lists[e].add(s);
        }
        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            result[i] = Integer.parseInt(st.nextToken());

        int index = 0;
        if (result[index++] != 1) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int p = q.poll();
                int pSize = 0;
                for (int k : lists[p]) {
                    if (visited[k]) continue;
                    visited[k] = true;
                    pSize++;
                }
                for (int i = index; i < index + pSize; i++) {
                    if (!visited[result[i]]) {
                        System.out.println(0);
                        return;
                    } else q.add(result[i]);
                }
                index += pSize;
            }
        }
        System.out.println(1);
    }
}
