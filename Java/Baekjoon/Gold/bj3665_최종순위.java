package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// https://escapefromcoding.tistory.com/207
public class bj3665_최종순위 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            List<Integer>[] list = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++)
                list[i] = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int[] degree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    list[arr[i]].add(arr[j]);
                    degree[arr[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (list[a].contains(b)) {
                    list[a].remove((Integer) b);
                    list[b].add(a);
                    degree[b]--;
                    degree[a]++;
                } else {
                    list[b].remove((Integer) a);
                    list[a].add(b);
                    degree[a]--;
                    degree[b]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) {
                    cnt++;
                    q.add(i);
                }
            }

            if (cnt > 1) {
                sb.append("?").append("\n");
                continue;
            }

            StringBuilder result = new StringBuilder();
            boolean isFinished = false;
            for (int i = 1; i <= n; i++) {
                if (q.isEmpty()) {
                    sb.append("IMPOSSIBLE").append("\n");
                    isFinished = true;
                    break;
                }

                int from = q.poll();

                result.append(from).append(" ");
                for (int to : list[from]) {
                    degree[to]--;
                    if (degree[to] == 0) q.add(to);
                }
            }
            if (!isFinished) {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}
