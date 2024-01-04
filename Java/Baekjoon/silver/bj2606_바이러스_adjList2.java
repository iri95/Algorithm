package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2606_바이러스_adjList2 {
	
	static int V, E;
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		int cnt = 0;
		boolean[] visit = new boolean[V+1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		visit[1] = true;
		while(!queue.isEmpty()) {
			int s = queue.poll();
			for (int j = 0; j < adjList[s].size(); j++) {
				int k = adjList[s].get(j);
				if(!visit[k]) {
					queue.offer(k);
					cnt++;
					visit[k] = true;
				}
			}
		}
		System.out.println(cnt);

	}

}
