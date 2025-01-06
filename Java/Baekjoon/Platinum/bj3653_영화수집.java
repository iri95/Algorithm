package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3653_영화수집 {
    private static class FenwickTree{
        int[] tree;

        public FenwickTree(int n){
            tree = new int[n + 1];
        }

        public int sum(int pos){
            int result = 0;
            while(pos > 0){
                result += tree[pos];
                pos &= (pos - 1);
            }
            return result;
        }

        public void add(int pos, int val){
            while(pos < tree.length){
                tree[pos] += val;
                pos += (pos & -pos);
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            FenwickTree fenwickTree = new FenwickTree(n + m);
            int[] index = new int[n + m + 1];
            for (int i = m + 1; i <= n + m; i++) {
                fenwickTree.add(i , 1);
                index[i - m] = i;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(fenwickTree.sum(index[num] - 1)).append(" ");
                fenwickTree.add(index[num], -1);
                fenwickTree.add(m - i, 1);
                index[num] = m - i;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
