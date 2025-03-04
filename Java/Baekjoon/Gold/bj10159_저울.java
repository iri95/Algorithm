package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj10159_저울 {
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] down = new ArrayList[N + 1];
        List<Integer>[] up = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            down[i] = new ArrayList<>();
            up[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            down[a].add(b);
            up[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            sb.append(N - dfs(i, up) - dfs(i, down) + 1).append("\n");
        }

        System.out.println(sb);
    }
    private static int dfs(int n, List<Integer>[] link){
        int count = 1;
        for (int next : link[n]) {
            if(visited[next]) continue;
            visited[next] = true;
            count += dfs(next, link);
        }
        return count;
    }
}
