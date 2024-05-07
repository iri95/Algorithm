package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13422_도둑 {
    static int N, M, K;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            list = new int[N + M - 1];
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = N; i < N + M - 1; i++) {
                list[i] = list[i - N];
            }
            sb.append(sol()).append("\n");
        }
        System.out.println(sb);
    }

    static int sol() {
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = M;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            sum += list[i];
            visited[i] = true;
        }
        if (sum < K) count++;
        while (end < N + M - 1 && !visited[end % N]) {
            visited[start] = false;
            sum -= list[start++];
            visited[end % N] = true;
            sum += list[end++];
            if (sum < K) count++;
        }

        return count;
    }
}
