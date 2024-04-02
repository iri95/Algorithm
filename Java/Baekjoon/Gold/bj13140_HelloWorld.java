package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj13140_HelloWorld {
    static int N;
    static boolean[] visit;
    static int[] hw;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visit = new boolean[10];
        hw = new int[7];
        permutation(0);
        if (sb.length() > 0) System.out.println(sb);
        else System.out.println("No Answer");

    }

    static void permutation(int count) {
        if (sb.length() > 0) return;
        if (count >= 7) {
            int hello = hw[0] * 10000 + hw[1] * 1000 + hw[2] * 110 + hw[3];
            int world = hw[4] * 10000 + hw[3] * 1000 + hw[5] * 100 + hw[2] * 10 + hw[6];
            if (hello + world == N) {
                sb.append("  ").append(hello).append("\n")
                        .append("+ ").append(world).append("\n")
                        .append("-------").append("\n");
                if (N / 100000 >= 1) sb.append(" ").append(N);
                else sb.append("  ").append(N);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if ((count == 0 || count == 4) && i == 0 || visit[i]) continue;
            visit[i] = true;
            hw[count] = i;
            permutation(count + 1);
            visit[i] = false;
        }
    }
}
