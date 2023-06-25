package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// https://moonsbeen.tistory.com/101
public class bj1167_트리의지름  {
    static int N, ans, nodeSave;

    static class Node {
        int num, meter;

        public Node(int num, int meter) {
            this.num = num;
            this.meter = meter;
        }
    }
    static ArrayList<Node>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            while (true) {
                int child = Integer.parseInt(st.nextToken());
                if(child == -1)break;
                int meter = Integer.parseInt(st.nextToken());
                list[k].add(new Node(child, meter));
            }
        }
        visit = new boolean[N + 1];
        dfs(1, 0);

        visit = new boolean[N + 1];
        dfs(nodeSave, 0);
        System.out.println(ans);

    }

    static void dfs(int num, int diameter) {
        if(diameter > ans){
            ans = diameter;
            nodeSave = num;
        }
        visit[num] = true;

        for (Node node : list[num]) {
            if (!visit[node.num]) {
                dfs(node.num, diameter + node.meter);
            }
        }
    }
}
