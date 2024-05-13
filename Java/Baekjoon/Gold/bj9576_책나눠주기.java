package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class bj9576_책나눠주기 {
    static int N, M;
    static int[] num;
    static boolean[] visited;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            num = new int[N + 1];
            list = new ArrayList[M + 1];
            for (int i = 0; i <= M; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                for (int j = s; j <= e; j++) {
                    list[i].add(j);
                }
            }
            int count = 0;
            visited = new boolean[N + 1];
            for (int i = 1; i <= M; i++) {
                Arrays.fill(visited, false);
                if (dfs(i)) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static boolean dfs(int number) {
        for (int p : list[number]) {
            if (!visited[p]) {
                visited[p] = true;
                if (num[p] == 0 || dfs(num[p])) {
                    num[p] = number;
                    return true;
                }
            }
        }
        return false;
    }
}
