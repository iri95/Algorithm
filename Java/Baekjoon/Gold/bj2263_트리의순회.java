package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2263_트리의순회 {
    static int[] in, post, index;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        in = new int[N + 1];
        post = new int[N + 1];
        index = new int[N + 1];
        for (int i = 0; i < N; i++) in[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) post[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) index[in[i]] = i;
        div(0, N - 1, 0, N - 1);
        System.out.println(sb);
    }

    private static void div(int il, int ir, int pl, int pr) {
        if (il > ir || pl > pr) return;

        int root = post[pr];
        sb.append(root).append(" ");

        int inIndex = index[root];
        div(il, inIndex - 1, pl, pl + inIndex - il - 1);
        div(inIndex + 1, ir, pl + inIndex - il, pr - 1);
    }
}
