package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1516_게임게발 {
    static class Node{
        int number;
        int length;
        int finishTime;
        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N + 1];
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }
        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i].number = i;
            nodes[i].length = Integer.parseInt(st.nextToken());
            int k = 0;
            while ((k = Integer.parseInt(st.nextToken())) != -1) {
                nodes[i].before.add(k);
                nodes[k].after.add(i);
            }
            if (nodes[i].before.isEmpty()) queue.offer(nodes[i]);
        }

        int result = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visit[node.number])continue;
            if (node.before.isEmpty()) {
                node.finishTime = node.length;
                for (int k : node.after) {
                    queue.offer(nodes[k]);
                }
            }
            boolean can = true;
            int max = 0;
            for (int k:node.before) {
                if (!visit[k]) {
                    can = false;
                    break;
                }
                max = Math.max(nodes[k].finishTime, max);
            }
            if (!can) continue;
            visit[node.number] = true;
            node.finishTime = max + node.length;
            for (int k : node.after) {
                queue.offer(nodes[k]);
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(nodes[i].finishTime);
        }
    }
}
