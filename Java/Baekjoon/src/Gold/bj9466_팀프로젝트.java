package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// https://yudaeng-log.tistory.com/56
public class bj9466_팀프로젝트 {
    static int N, number, result;
    static int[] list;
    // visit : 전체에서 방문 여부
    // circle : 한번의 dfs에서의 방문 여부
    static boolean[] visit, circle;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            list = new int[N + 1];
            visit = new boolean[N + 1];
            circle = new boolean[N + 1];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < N + 1; j++) {
                if (!circle[j]) {
                    dfs(j);
                }
            }
            sb.append(N - result).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int num) {
        visit[num] = true;
        int next = list[num];
        if (!visit[next]) {
            dfs(next);
        }
        if (visit[next] && !circle[next]) {
            result++;
            while (next != num) {
                result++;
                next = list[next];
            }
        }
        circle[num] = true;
    }
}