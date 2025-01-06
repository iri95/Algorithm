package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16975_수열과쿼리21 {
    private static class FenwickTree {
        long[] tree;

        FenwickTree(int n) {
            tree = new long[n + 1];
        }

        public long sum(int pos) {
            long result = 0;
            while (pos > 0) {
                result += tree[pos];
                pos &= (pos - 1);
            }
            return result;
        }

        public void add(int pos, int value) {
            while (pos < tree.length) {
                tree[pos] += value;
                pos += (pos & -pos);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        FenwickTree fen = new FenwickTree(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pre = 0;
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            fen.add(i, value - pre);
            pre = value;
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                fen.add(s, value);
                if (e <= N) fen.add(e + 1, -value);
            } else {
                int pos = Integer.parseInt(st.nextToken());
                sb.append(fen.sum(pos)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
