package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj28325_호숫가의개미굴 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] C = new long[N];
        long sum = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            C[i] = Long.parseLong(st.nextToken());
            if (C[i] != 0) {
                sum += C[i];
                visited[i] = true;
            }
        }

        long a = 0;
        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                a++;
                i++;
            }
        }

        long b = 0;
        for (int i = 1; i < N; i++) {
            if (!visited[i]) {
                b++;
                i++;
            }
        }

        System.out.println(a >= b ? sum + a : sum + b);
    }
}
