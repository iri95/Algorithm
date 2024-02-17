package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj1629_곱셈 {
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        map.put(1L, A % C);
        System.out.println(divide(A, B, C));
    }

    static long divide(long a, long b, long c) {
        if (map.containsKey(b)) return map.get(b);
        long k = divide(a, b / 2, c) % c;
        map.put(b / 2, k);
        return b % 2 == 0 ? k * k % c : k * k % c * map.get(1L) % c;
    }
}
