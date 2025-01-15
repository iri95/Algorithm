package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj14725_개미굴 {
    private static class Node implements Comparable<Node> {
        String name;
        List<Node> sub = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public Node add(Node n) {
            for (Node s : this.sub)
                if (s.name.equals(n.name)) return s;
            this.sub.add(n);
            return n;
        }

        public int compareTo(Node n) {
            return this.name.compareTo(n.name);
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node("root");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node cur = root;
            for (int j = 0; j < k; j++) {
                Node n = new Node(st.nextToken());
                cur = cur.add(n);
            }
        }
        Collections.sort(root.sub);
        for (Node next : root.sub) {
            getResult(next, 0);
        }
        System.out.println(sb);
    }

    private static void getResult(Node n, int depth) {
        Collections.sort(n.sub);
        for (int i = 0; i < depth; i++) sb.append("--");
        sb.append(n.name).append("\n");
        for (Node next : n.sub) {
            getResult(next, depth + 1);
        }
    }
}
