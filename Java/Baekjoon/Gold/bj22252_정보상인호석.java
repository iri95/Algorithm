package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj22252_정보상인호석 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        Map<String, Queue<Integer>> map = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("1")) {
                String name = st.nextToken();
                if (!map.containsKey(name)) map.put(name, new PriorityQueue<>(Comparator.reverseOrder()));
                int k = Integer.parseInt(st.nextToken());
                Queue<Integer> q = map.get(name);
                while (k-- > 0) q.add(Integer.parseInt(st.nextToken()));
            } else {
                String name = st.nextToken();
                if (map.containsKey(name)) {
                    int count = Integer.parseInt(st.nextToken());
                    Queue<Integer> q = map.get(name);
                    while (count-- > 0 && !map.get(name).isEmpty()) answer += q.poll();
                }
            }
        }
        System.out.println(answer);
    }
}
