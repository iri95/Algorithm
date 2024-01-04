package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1976_여행가자 {
    static int N, M;
    static int[][] map;
    static boolean[] visit, route;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visit = new boolean[N+1];
        route = new boolean[N+1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int startNo = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (i == 0) {
                startNo =Integer.parseInt(st.nextToken());
                route[startNo] = true;
                continue;
            }
            route[Integer.parseInt(st.nextToken())] = true;
        }
        dfs(startNo);
        for (int i = 1; i <= N; i++) {
            if(route[i]){
                if(!visit[i]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }
    static void dfs(int start){
        if(visit[start])return;
        visit[start] = true;
        for (int i = 1; i <= N; i++) {
            if (map[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
