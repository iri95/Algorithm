package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13325_이진트리 {
    static int N, M;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = 1 << (N + 1);
        arr = new int[M + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());
        sol(1);
        System.out.println(answer);
    }

    private static int sol(int n){
        answer += arr[n];
        if(2 * n >= M) return arr[n];
        int a = sol(2 * n);
        int b = sol(2 * n + 1);
        answer += Math.abs(a - b);
        return arr[n] + Math.max(a, b);
    }
}
