package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2051_최소버텍스커버 {
    static int[] A, B;
    static boolean[] visited, visitA, visitB;
    static List<Integer>[] lines;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lines = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) lines[i] = new ArrayList<>();
        A = new int[N + 1];// Alternating Path를 구현하기 위해 A와 매칭된 B의 정점도 저장한다.
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            while(c-- > 0){
                int a = Integer.parseInt(st.nextToken());
                lines[i].add(a);
            }
        }

        int matching = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[M + 1];
            if (bipartiteMatching(i)) matching++; // 콰닉의 정리에 의해 Max Matching = Minimum Vertex Cover
        }

        /*
        Minimum Vertex Cover의 값은 구했으니 정점을 구해야 한다. 정점은 Alternating Path를 사용한다.
        A 정점을 중심으로 Alternating Path를 탐색하기 때문에
        A 집합의 탐색하지 않은 정점이 Cover에 속하고
        B 집합의 탐색한 정점이 Cover에 속한다.
         */
        visitA = new boolean[N + 1];
        visitB = new boolean[M + 1];
        for (int i = 1; i <= N; i++) {
            if (A[i] == 0) alternatingPath(i);
        }
        List<Integer> coverA = new ArrayList<>();
        List<Integer> coverB = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            if(!visitA[i] && !lines[i].isEmpty()) coverA.add(i);

        for (int i = 1; i <= M; i++)
            if(visitB[i]) coverB.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append(matching).append("\n");
        sb.append(coverA.size()).append(" ");
        for (int a : coverA) sb.append(a).append(" ");
        sb.append("\n").append(coverB.size()).append(" ");
        for (int b : coverB) sb.append(b).append(" ");
        System.out.println(sb);
    }
    // 이분 매칭 알고리즘
    static boolean bipartiteMatching(int n){
        for (int next : lines[n]) {
            if(visited[next]) continue;
            visited[next] = true;
            if(B[next] == 0 || bipartiteMatching(B[next])){
                B[next] = n;
                A[n] = next;
                return true;
            }
        }
        return false;
    }

    // Alternating Path
    static void alternatingPath(int n){
        if(visitA[n]) return;
        visitA[n] = true;
        for (int b : lines[n]) {
            if(B[b] != 0 && B[b] != n){
                visitB[b] = true;
                alternatingPath(B[b]);
            }
        }
    }
}
