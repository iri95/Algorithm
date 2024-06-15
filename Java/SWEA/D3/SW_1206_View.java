package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1206_View {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N, ans;
        int[] list;
        for (int t = 1; t <= 10; t++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());
            list = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(Math.max(list[i - 2], list[i - 1]), Math.max(list[i + 1], list[i + 2]));
                if (max >= list[i]) continue;
                ans += list[i] - max;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
