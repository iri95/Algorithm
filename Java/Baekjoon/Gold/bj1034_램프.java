package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj1034_램프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] list = new String[N];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            list[i] = str;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int K = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt0 = 0;
            for (int j = 0; j < M; j++) if (list[i].charAt(j) == '0') cnt0++;
            if (cnt0 > K || (K - cnt0) % 2 != 0) continue;
            ans = Math.max(ans, map.get(list[i]));
        }
        System.out.println(ans);
    }
}
