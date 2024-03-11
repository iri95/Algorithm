package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj1351_무한수열 {
    static long N, P, Q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map.put(0L, 1L);
        System.out.println(depth(N));
    }
    static long depth(long n) {
        if (map.containsKey(n)) return map.get(n);
        map.put(n, depth(n / P) + depth(n / Q));
        return map.get(n);
    }
}
