package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1764_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Character> noListen = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            noListen.put(br.readLine(), ' ');
        }
        for (int i = 0; i < M; i++) {
            String a = br.readLine();
            if (noListen.containsKey(a)) {
                result.add(a);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
