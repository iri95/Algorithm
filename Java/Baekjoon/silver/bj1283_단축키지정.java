package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj1283_단축키지정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            int n = strs.length;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                char ch = Character.toUpperCase(strs[j].charAt(0));
                if (!set.contains(ch)) {
                    flag = true;
                    set.add(ch);
                    strs[j] = "[" + strs[j].charAt(0) + "]" + strs[j].substring(1);
                    break;
                }
            }
            if (flag) {
                for (String str : strs) sb.append(str).append(" ");
                sb.append("\n");
                continue;
            }
            flag = false;
            for (String str : strs) {
                for (int k = 0; k < str.length(); k++) {
                    char ch = Character.toUpperCase(str.charAt(k));
                    if (!set.contains(ch) && !flag) {
                        flag = true;
                        set.add(ch);
                        sb.append("[").append(str.charAt(k)).append("]");
                    } else sb.append(str.charAt(k));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
