package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1017_소수쌍 {
    static boolean[] visit, prime = new boolean[2001];
    static int[] parent;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        parent = new int[N];
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }

        setPrime();
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (i == j) continue;
                if (prime[arr[i] + arr[j]])
                    lists[i].add(j);
            }
        }


        List<Integer> answer = new ArrayList<>();
        for (int ven : lists[0]) {
            int cnt = 1;
            Arrays.fill(parent, -1);
            parent[0] = parent[ven] = 0;
            for (int i = 1; i < N; i++) {
                if (parent[i] != -1) continue;
                visit = new boolean[N];
                visit[ven] = visit[0] = true;
                if (dfs(i)) cnt++;
            }
            if (cnt == N / 2) answer.add(arr[ven]);
        }
        if (answer.isEmpty()) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(answer);
            for (int i = 0; i < answer.size(); i++)
                sb.append(answer.get(i)).append(" ");
            System.out.println(sb);
        }
    }

    private static boolean dfs(int n) {
        for (int next : lists[n]) {
            if (visit[next]) continue;
            visit[next] = true;
            if (parent[next] == -1 || dfs(parent[next])) {
                parent[next] = n;
                parent[n] = next;
                return true;
            }
        }
        return false;
    }

    private static void setPrime() {
        Arrays.fill(prime, true);
        int len = (int) Math.sqrt(2000);
        for (int i = 2; i <= len; i++) {
            for (int j = i * 2; j <= 2000; j += i) {
                prime[j] = false;
            }
        }
    }
}
