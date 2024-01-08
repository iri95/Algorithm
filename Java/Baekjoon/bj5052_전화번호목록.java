import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj5052_전화번호목록 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] list = new String[n];
            Set<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                list[j] = br.readLine();
                set.add(list[j]);
            }
            boolean result = false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < list[j].length(); k++) {
                    if (set.contains(list[j].substring(0, k))) {
                        result = true;
                        break;
                    }
                }
                if (result) break;
            }
            if (result) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}
