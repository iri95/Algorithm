package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://wooooooak.github.io/algorithm/2018/12/05/%EB%B0%B1%EC%A4%802250%EB%AC%B8%EC%A0%9C/
public class bj2250_트리의높이와너비 {
    // point : 현재 x좌표 (노드를 방문할 때 마다 +1 증가)
    static int point = 1;
    static Node[] tree;
    static int[] levelMin;
    static int[] levelMax;
    static int maxLevel = 0; // 트리의 최대 레벨(깊이)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        levelMin = new int[N + 1];
        levelMax = new int[N + 1];
        int rootIndex = 0;
        for (int i = 0; i <= N; i++) {
            tree[i] = new Node();
            levelMin[i] = N;
            levelMax[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[num].left = left;
            tree[num].right = right;
            if (left != -1) tree[left].parent = num;
            if (right != -1) tree[right].parent = num;
        }

        for (int i = 1; i <= N; i++) {
            if (tree[i].parent == -1) {
                rootIndex = i;
                break;
            }
        }

        inOrder(rootIndex, 1);

        int ansLv = 1;
        int ansWid = levelMax[1] - levelMin[1] + 1;
        for (int i = 2; i <= maxLevel; i++) {
            int width = levelMax[i] - levelMin[i] + 1;
            if (ansWid < width) {
                ansLv = i;
                ansWid = width;
            }
        }
        System.out.println(ansLv + " " + ansWid);
    }

    public static void inOrder(int rootIndex, int level) {
        Node root = tree[rootIndex];
        if (maxLevel < level) maxLevel = level;
        if (root.left != -1) {
            inOrder(root.left, level + 1);
        }

        levelMin[level] = Math.min(levelMin[level], point);
        levelMax[level] = point;
        point++;

        if (root.right != -1) {
            inOrder(root.right, level + 1);
        }
    }

    static class Node {
        int left, right, parent = -1;
    }
}
