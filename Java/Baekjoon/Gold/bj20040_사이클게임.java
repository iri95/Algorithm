package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/source/71809141
public class bj20040_사이클게임 {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        make();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!union(a, b)) { // -> find 함수 최소로 실행
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }
    // make 함수를 만든 것 만드로 692ms -> 532ms로 시간 단축됨.
    static void make(){
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    }
}
