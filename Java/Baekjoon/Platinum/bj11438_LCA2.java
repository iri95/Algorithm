package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj11438_LCA2 {
    static int N, H;
    static int[] depth;
    static List<Integer>[] lists;
    static int[][] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        lists = new ArrayList[N + 1];
        depth = new int[N + 1];
        parents = new int[N + 1][H];
        for (int i = 0; i <= N; i++) lists[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int[] cur = q.poll();
                depth[cur[0]] = cnt;
                for (int next : lists[cur[0]]) {
                    if (next == cur[1]) continue;
                    parents[next][0] = cur[0];
                    q.add(new int[]{next, cur[0]});
                }
            }
        }

        for (int i = 1; i < H; i++)
            for (int j = 1; j <= N; j++)
                parents[j][i] = parents[parents[j][i - 1]][i - 1];

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = H - 1; i >= 0; i--)
            if (1 << i <= depth[a] - depth[b]) a = parents[a][i];

        if (a == b) return a;

        for (int i = H - 1; i >= 0; i--) {
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }
        return parents[a][0];
    }
}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class LCA2 {

    static int[] depth, tree;
    static List<Integer> visit = new ArrayList<>();
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        depth = new int[N + 1];
        depth[0] = Integer.MAX_VALUE;
        lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) lists[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        preorder(1, 1, 0);

        int[] order = new int[N + 1];
        Arrays.fill(order, -1);
        for (int i = 0; i < visit.size(); i++) {
            int a = visit.get(i);
            if(order[a] == -1) order[a] = i;
        }

        int treeH = (int) Math.ceil(Math.log(visit.size()) / Math.log(2)) + 1;
        tree = new int[1 << treeH];

        init(1, 0, visit.size() - 1);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = order[a];
            int e = order[b];
            if(s > e){
                int temp = s;
                s = e;
                e = temp;
            }
            sb.append(query(1, 0, visit.size() - 1, s, e)).append("\n");
        }
        System.out.println(sb);

    }

    private static void preorder(int node, int d, int p) {
        depth[node] = d;
        visit.add(node);
        for (int next : lists[node]) {
            if (next == p) continue;
            preorder(next, d + 1, node);
            visit.add(node);
        }
    }

    private static int init(int node, int start, int end) {
        if (start == end) return tree[node] = visit.get(start);
        int a = init(node * 2, start, (start + end) / 2);
        int b = init(node * 2 + 1, (start + end) / 2 + 1, end);
        return tree[node] = depth[a] > depth[b] ? b : a;
    }

    private static int query(int node, int start, int end, int findS, int findE){
        if(findE < start || end < findS) return 0;
        if(findS <= start && end <= findE) return tree[node];
        int a = query(node * 2, start, (start + end) / 2, findS, findE);
        int b = query(node * 2 + 1, (start + end) / 2 + 1, end,  findS, findE);
        return depth[a] > depth[b] ? b : a;
    }
}

 */