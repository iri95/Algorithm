package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bj2517_달리기 {
    public static class FenwickTree {
        static int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1];
        }

        int sum(int pos) {
            int result = 0;
            while (pos > 0) {
                result += tree[pos];
                pos &= (pos - 1);
            }
            return result;
        }

        void add(int pos, int val) {
            while (pos < tree.length) {
                tree[pos] += val;
                pos += (pos & -pos);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        FenwickTree fenwick = new FenwickTree(N);
        int[] arr = new int[N + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        int[] answer = new int[N + 1];
        for (int i = N; i > 0; i--) {
            int index = map.get(arr[i]);
            answer[index] = fenwick.sum(index - 1) + 1;
            fenwick.add(index, 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(answer[i]).append("\n");

        System.out.println(sb);
    }
}
