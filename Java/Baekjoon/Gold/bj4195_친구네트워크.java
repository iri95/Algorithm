package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj4195_친구네트워크 {
    static Map<String, String> map;
    static Map<String, Integer> cntMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            cntMap = new HashMap<>();
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, a);
                    cntMap.put(a, 1);
                }
                if (!map.containsKey(b)) {
                    map.put(b, b);
                    cntMap.put(b, 1);
                }
                parent(a, b);
                sb.append(cntMap.get(find(a))).append("\n");
            }
        }
        System.out.println(sb);
    }

    static String find(String str) {
        if (map.get(str).equals(str)) return str;
        else return find(map.get(str));
    }

    static void parent(String str1, String str2) {
        String str1P = find(str1);
        String str2P = find(str2);
        if (str1P.equals(str2P)) return;
        if (str1P.compareTo(str2P) < 0) {
            map.put(str2P, str1P);
            cntMap.put(str1P, cntMap.get(str1P) + cntMap.get(str2P));
        } else {
            map.put(str1P, str2P);
            cntMap.put(str2P, cntMap.get(str1P) + cntMap.get(str2P));
        }

    }
}
