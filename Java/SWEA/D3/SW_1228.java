package D3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1228 {
	static int N, M, index, count;
	static LinkedList<Integer> ll = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			ll.clear();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ll.add(Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				st.nextToken();
				index = Integer.parseInt(st.nextToken());
				count = Integer.parseInt(st.nextToken());
				for (int j = index; j < index + count; j++) {
					ll.add(j, Integer.parseInt(st.nextToken()));
				}
			}
			sb.append("#" + t);
			for(int i = 0; i < 10; i++) {
				sb.append(" " + ll.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
