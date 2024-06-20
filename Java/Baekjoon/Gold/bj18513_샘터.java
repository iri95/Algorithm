package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj18513_샘터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            set.add(a);
            q.add(a);
        }
        long answer = 0;
        int move = 0;
        int count = 0;
        bfs : while (count < K) {
            int size = q.size();
            move++;
            while (size-- > 0) {
                int n = q.poll();
                int minus = n - 1;
                int plus = n + 1;
                if (!set.contains(minus)) {
                    set.add(minus);
                    q.add(minus);
                    answer += move;
                    count++;
                }
                if (count == K) break bfs;
                if (!set.contains(plus)) {
                    set.add(plus);
                    q.add(plus);
                    answer += move;
                    count++;
                }
                if (count == K) break bfs;
            }
        }
        System.out.println(answer);
    }
}
