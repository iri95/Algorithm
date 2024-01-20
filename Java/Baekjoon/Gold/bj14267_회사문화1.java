package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14267_회사문화1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int[] point = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[x] += y;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(point[1]).append(" ");
        for (int i = 2; i <= n; i++) {
            point[i] += point[list[i]];
            sb.append(point[i]).append(" ");
        }
        System.out.println(sb);
    }
}
