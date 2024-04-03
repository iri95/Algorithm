import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1039_교환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int M = N.length();
        int K = Integer.parseInt(st.nextToken());
        if (M == 1 || (M == 2 && N.charAt(1) == '0')) {
            System.out.println(-1);
            return;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(N);
        while (!queue.isEmpty() && K-- > 0) {
            int size = queue.size();
            boolean[] visit = new boolean[1_000_001];
            while (size-- > 0) {
                String str = queue.poll();
                for (int i = 0; i < M - 1; i++) {
                    for (int j = i + 1; j < M; j++) {
                        String a = "";
                        if (i > 0) a += str.substring(0, i);
                        a += str.charAt(j);
                        if (j - i > 1) a += str.substring(i + 1, j);
                        a += str.charAt(i);
                        if (j < M - 1) a += str.substring(j + 1);
                        if (a.charAt(0) == '0' || visit[Integer.parseInt(a)]) continue;
                        visit[Integer.parseInt(a)] = true;
                        queue.add(a);
                    }
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int s = Integer.parseInt(queue.poll());
            max = Math.max(s, max);
        }
        System.out.println(max);
    }
}
