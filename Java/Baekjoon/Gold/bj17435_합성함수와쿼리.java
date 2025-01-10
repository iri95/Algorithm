package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17435_합성함수와쿼리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int high = (int) Math.ceil(Math.log(500_000) / Math.log(2));
        int[][] parent = new int[N + 1][high];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) parent[i][0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < high; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i -1];
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for (int j = high - 1; j >= 0; j--) {
                if(1 << j <= c) {
                    num = parent[num][j];
                    c -= 1 << j;
                }
            }
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
