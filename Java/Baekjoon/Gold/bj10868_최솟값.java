package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10868_최솟값 {
    static int N, M;
    static int[] arr, tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        double high = Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int cnt = (int) Math.pow(2, high);
        tree = new int[cnt];

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(find(1, 1, N, s, e)).append("\n");
        }
        System.out.println(sb);
    }
    private static int init(int n, int start, int end){
        if(start == end) return tree[n] = arr[start];
        int a = init(2 * n, start, (start + end) / 2);
        int b = init(2 * n + 1, (start + end) / 2 + 1, end);
        return tree[n] = Math.min(a, b);
    }

    private static int find(int n, int start, int end, int tStart, int tEnd){
        if(tEnd < start || tStart > end) return 1_000_000_001;
        if(tStart <= start && end <= tEnd) return tree[n];
        int a = find(2 * n, start, (start + end) / 2, tStart, tEnd);
        int b = find(2 * n + 1, (start + end) / 2 + 1, end, tStart, tEnd);
        return Math.min(a, b);
    }
}
