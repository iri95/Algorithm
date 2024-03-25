package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj13904_과제 {
    static class Node implements Comparable<Node>{
        int end;
        int score;
        public Node(int end, int score){
            this.end = end;
            this.score = score;
        }
        public int compareTo(Node o){
            if(this.score == o.score) return this.end - o.end;
            return o.score - this.score;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(end, score);
            maxTime = Math.max(end, maxTime);
        }
        Arrays.sort(nodes, (o1, o2)-> o2.end - o1.end);
        Queue<Node> pq = new PriorityQueue<>();
        int index = 0;
        int answer  = 0;
        while (maxTime > 0) {
            for (int i = index; i < N && maxTime <= nodes[i].end; i++) {
                pq.add(nodes[i]);
                index++;
            }
            if(!pq.isEmpty()) answer += pq.poll().score;
            maxTime--;
        }
        System.out.println(answer);
    }
}
