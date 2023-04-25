package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2606_바이러스_matrix {
	static int V, E;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		matrix = new int[V+1][V+1];
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from =Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		boolean[] visit = new boolean[V+1];
		visit[1] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 1; i <= V; i++) {
				if(matrix[k][i]==1 && !visit[i]) {
					visit[i] = true;
					cnt++;
					queue.offer(i);
				}
			}
		}
		System.out.println(cnt);
	}

}
