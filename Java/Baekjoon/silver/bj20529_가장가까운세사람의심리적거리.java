package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20529_가장가까운세사람의심리적거리 {
    static int N;
    static String[] strings;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            if (N > 32) {
                sb.append(0).append("\n");
                continue;
            }
            strings = new String[N];
            for (int i = 0; i < N; i++) strings[i] = st.nextToken();
            sb.append(sol()).append("\n");
        }
        System.out.println(sb);
    }

    private static int sol() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 2; i++) {
            String a = strings[i];
            for (int j = i + 1; j < N - 1; j++) {
                String b = strings[j];
                for (int k = j + 1; k < N; k++) {
                    String c = strings[k];
                    int sum = 0;
                    for (int l = 0; l < 4; l++) if(a.charAt(l) != b.charAt(l)) sum++;
                    for (int l = 0; l < 4; l++) if(a.charAt(l) != c.charAt(l)) sum++;
                    for (int l = 0; l < 4; l++) if(c.charAt(l) != b.charAt(l)) sum++;
                    min = Math.min(min, sum);
                }
            }
        }
        return min;
    }
}
