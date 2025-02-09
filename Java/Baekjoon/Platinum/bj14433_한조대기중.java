package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj14433_한조대기중 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K1 = Integer.parseInt(st.nextToken());
        int K2 = Integer.parseInt(st.nextToken());

        List<Integer>[] lists1 = new ArrayList[N + 1];
        List<Integer>[] lists2 = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            lists1[i] = new ArrayList<>();
            lists2[i] = new ArrayList<>();
        }

        for (int i = 0; i < K1; i++) {
            st = new StringTokenizer(br.readLine());
            int player = Integer.parseInt(st.nextToken());
            int pick = Integer.parseInt(st.nextToken());
            lists1[player].add(pick);
        }

        for (int i = 0; i < K2; i++) {
            st = new StringTokenizer(br.readLine());
            int player = Integer.parseInt(st.nextToken());
            int pick = Integer.parseInt(st.nextToken());
            lists2[player].add(pick);
        }


        int[] parent1 = new int[M + 1];
        int[] parent2 = new int[M + 1];
        Arrays.fill(parent1, -1);
        Arrays.fill(parent2, -1);

        int count1 = 0;
        int count2 = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            if (matching(i, parent1, visited, lists1)) count1++;
        }

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            if (matching(i, parent2, visited, lists2)) count2++;
        }

        if (count1 < count2) System.out.println("네 다음 힐딱이");
        else System.out.println("그만 알아보자");
    }
    private static boolean matching(int n, int[] parent, boolean[] visited, List<Integer>[] list){
        if(visited[n]) return false;
        visited[n] = true;

        for (int pick : list[n]) {
            if (parent[pick] == -1 || matching(parent[pick], parent, visited, list)){
                parent[pick] = n;
                return true;
            }
        }
        return false;
    }
}
