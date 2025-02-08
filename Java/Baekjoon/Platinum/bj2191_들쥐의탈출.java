package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj2191_들쥐의탈출 {
    private static class Rat {
        double x, y;

        Rat(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean canHide(double hx, double hy, int sv) {
            return Math.ceil(Math.pow(x - hx, 2) + Math.pow(y - hy, 2)) <= Math.pow(sv, 2);
        }
    }
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int sv = S * V;
        Rat[] rats = new Rat[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rats[i] = new Rat(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) lists[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (rats[j].canHide(x, y, sv)) lists[j].add(i);
            }
        }

        parent = new int[M];
        Arrays.fill(parent, -1);

        int count = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (matching(i)) count++;
        }

        System.out.println(N - count);

    }
    private static boolean matching(int n){
        if (visited[n]) return false;
        visited[n] = true;
        for (int hole : lists[n]) {
            if (parent[hole] == -1 || matching(parent[hole])){
                parent[hole] = n;
                return true;
            }
        }
        return false;
    }
}
