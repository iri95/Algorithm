package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1725_히스토그램 {

    static int N, INF = 1_000_000_001;
    static int[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        double high = Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int cnt = (int) Math.pow(2, high);
        tree = new int[cnt];
        init(1, 1, N);

        System.out.println(sol(1, N));
    }

    private static int init(int node, int start, int end) {
        if (start == end) return tree[node] = start;
        int a = init(node * 2, start, (start + end) / 2);
        int b = init(node * 2 + 1, (start + end) / 2 + 1, end);
        return tree[node] = arr[a] > arr[b] ? b : a;
    }

    private static int findIndex(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return INF;
        else if (left <= start && end <= right) return tree[node];
        int a = findIndex(node * 2, start, (start + end) / 2, left, right);
        int b = findIndex(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        if (a == INF) return b;
        else if (b == INF) return a;
        else return arr[a] > arr[b] ? b : a;
    }

    private static long sol(int start, int end) {
        int minIndex = findIndex(1, 1, N, start, end);
        long max = (long) arr[minIndex] * (end - start + 1);
        if (minIndex > start)
            max = Math.max(max, sol(start, minIndex - 1));

        if (minIndex < end)
            max = Math.max(max, sol(minIndex + 1, end));

        return max;
    }
}
