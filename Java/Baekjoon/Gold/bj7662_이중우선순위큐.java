package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class bj7662_이중우선순위큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (str.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    int key = num == -1 ? map.firstKey() : map.lastKey();
                    if (map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
            }
            if (map.isEmpty()) sb.append("EMPTY");
            else  sb.append(map.lastKey()).append(" ").append(map.firstKey());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
