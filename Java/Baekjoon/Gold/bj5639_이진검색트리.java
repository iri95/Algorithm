package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class bj5639_이진검색트리 {
    static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public void insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else this.left.insert(n);
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else this.right.insert(n);
            }
        }
    }

    static Node root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Queue<Integer> q = new ArrayDeque<>();
        root = new Node(Integer.parseInt(line));
        while (true) {
            line = br.readLine();
            if (line == null) break;
            q.add(Integer.parseInt(line));
        }
        while (!q.isEmpty()) root.insert(q.poll());
        post(root);
        System.out.println(sb);
    }

    private static void post(Node n) {
        if (n.left != null) post(n.left);
        if (n.right != null) post(n.right);
        sb.append(n.num).append("\n");

    }
}
