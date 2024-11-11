package lv3;

import java.util.*;

public class 길찾기게임 {
    static class Node implements Comparable<Node> {
        int num, x, y;
        Node left, right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node n) {
            if (this.y == n.y) return this.x - n.x;
            return n.y - this.y;
        }
    }

    static int index = 0;
    static int[][] answer;

    public int[][] solution(int[][] nodeinfo) {
        int N = nodeinfo.length;
        answer = new int[2][N];
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++)
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);

        Arrays.sort(nodes);
        for (int i = 1; i < N; i++)
            update(nodes[0], nodes[i]);

        pre(nodes[0]);
        index = 0;
        post(nodes[0]);

        return answer;
    }

    private static void update(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else update(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else update(parent.right, child);
        }
    }

    private static void post(Node n) {
        if (n.left != null) {
            post(n.left);
        }
        if (n.right != null) {
            post(n.right);
        }
        answer[1][index++] = n.num;
    }

    private static void pre(Node n) {
        answer[0][index++] = n.num;
        if (n.left != null) {
            pre(n.left);
        }
        if (n.right != null) {
            pre(n.right);
        }
    }
}
