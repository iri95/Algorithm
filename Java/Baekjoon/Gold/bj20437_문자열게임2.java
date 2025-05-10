package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj20437_문자열게임2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String str;
        int K, min, max, INF = 10_001;
        List<Integer>[] list;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            str = br.readLine();
            K = Integer.parseInt(br.readLine());

            list = new ArrayList[26];
            for (int i = 0; i < 26; i++)
                list[i] = new ArrayList<>();

            for (int i = 0; i < str.length(); i++)
                list[str.charAt(i) - 'a'].add(i);

            min = INF;
            max = -1;

            for (int i = 0; i < 26; i++) {
                for (int k = K - 1; k < list[i].size(); k++) {
                    int value = list[i].get(k) - list[i].get(k - K + 1) + 1;
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                }
            }

            if (min == INF || max == -1) sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
