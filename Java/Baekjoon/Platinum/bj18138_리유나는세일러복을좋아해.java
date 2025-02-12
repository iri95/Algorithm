package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj18138_리유나는세일러복을좋아해 {
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] lists;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N];
        parent = new int[M];
        Arrays.fill(parent, -1);
        double[] tShirt = new double[N];
        double[] kara = new double[M];

        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
            tShirt[i] = Double.parseDouble(br.readLine());
        }
        for (int i = 0; i < M; i++) kara[i] = Double.parseDouble(br.readLine());

        for (int i = 0; i < N; i++) {
            double tSize = tShirt[i];
            for (int j = 0; j < M; j++) {
                double karaSize = kara[j];
                if ((karaSize >= tSize / 2 && karaSize <= tSize * 3 / 4) || (karaSize >= tSize && karaSize <= tSize * 5 / 4)) {
                    lists[i].add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (matching(i)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean matching(int n){
        if (visited[n]) return false;
        visited[n] = true;
        for (int kara : lists[n]) {
            if (parent[kara] == -1 || matching(parent[kara])) {
                parent[kara] = n;
                return true;
            }
        }
        return false;
    }
}
