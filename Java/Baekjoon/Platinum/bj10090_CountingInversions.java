package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10090_CountingInversions {
    static int N;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int i = N; i > 0; i--) {
            result += sum(arr[i] - 1);
            update(arr[i]);
        }

        System.out.println(result);

    }

    private static void update(int index){
        for (int i = index; i <= N; i += (i & -i))
            tree[i]++;
    }

    private static int sum(int index){
        int sum = 0;
        for (int i = index; i > 0; i -= (i & -i))
            sum += tree[i];

        return sum;
    }

}
