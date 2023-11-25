package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1822_차집합 {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Map<String, Boolean> aMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            aMap.put(st2.nextToken(), true);
        }
        for (int i = 0; i < A; i++) {
            String value = st.nextToken();
            if (!aMap.containsKey(value)) {
                result.add(Integer.parseInt(value));
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        if(result.size()>0) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("수행시간: " + (float)(endTime - startTime)/1000);
    }
}
