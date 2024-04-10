package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/board/view/52592
// 분리 집합 union을 활용하는 부분이 너무 좋았습니다.
public class bj10775_공항 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) parent[i] = i;
        int count = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int p = find(g);
            if (p != 0){
                count++;
                union(p - 1, p);
            }else break;
        }
        System.out.println(count);
    }
    static int find(int child){
        if (child == parent[child]) return child;
        return parent[child] = find(parent[child]);
    }

    static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);
        if (aP > bP) parent[aP] = bP;
        else parent[bP] = aP;
    }
}
