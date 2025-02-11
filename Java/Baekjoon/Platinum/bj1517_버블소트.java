package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1517_버블소트 {
    public static class FenwickTree {
        static int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1];
        }

        long sum(int pos) {
            long result = 0;
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

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(arr[i], k -> new ArrayDeque<>()).push(i);
        }

        Arrays.sort(arr);
        FenwickTree fenwick = new FenwickTree(N);
        long answer = 0;
        for (int i = N; i > 0; i--) {
            int index = map.get(arr[i]).pop();
            answer += fenwick.sum(index - 1);
            fenwick.add(index, 1);
        }
        System.out.println(answer);
    }
}
/* Segment Tree
private static class SegmentTree {
        int[] tree;

        SegmentTree(int n) {
            int high = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
            tree = new int[1 << high];
        }

        int update(int node, int start, int end, int index, int diff) {
            if (index < start || end < index) return tree[node];
            if (start == end) return tree[node] += diff;
            return tree[node] = update(node * 2, start, (start + end) / 2, index, diff)
                    + update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }

        int sum(int node, int start, int end, int s, int e) {
            if (e < start || end < s) return 0;
            if (s <= start && end <= e) return tree[node];
            return sum(node * 2, start, (start + end) / 2, s, e)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, s, e);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(arr[i], k -> new ArrayDeque<>()).add(i);
        }

        Arrays.sort(arr);
        SegmentTree seg = new SegmentTree(N);
        long answer = 0;

        for (int i = 1; i <= N; i++) {
            int index = map.get(arr[i]).poll();
            answer += seg.sum(1, 1, N, index + 1, N);
            seg.update(1, 1, N, index, 1);
        }
        System.out.println(answer);
    }
 */