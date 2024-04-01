import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj10282_해킹 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        int d;
        int c;
        int sum;
        int count;
        List<int[]>[] after;
        boolean[] visited;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sum = 0;
            count = 0;
            after = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
            queue.add(new int[] {c, 0});
            for (int i = 0; i <= n; i++) {
                after[i] = new ArrayList<>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                after[b].add(new int[]{a, s});
            }
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (visited[now[0]]) continue;
                sum = now[1];
                count++;
                visited[now[0]] = true;
                for (int[] p: after[now[0]]) {
                    if (visited[p[0]]) continue;
                    queue.add(new int[] {p[0], p[1] + now[1]});
                }
            }
            sb.append(count).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
