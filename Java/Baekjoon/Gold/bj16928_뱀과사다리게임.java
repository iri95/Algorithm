package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16928_뱀과사다리게임 {
    static int N, M;
    static int[] map = new int[101];
    static boolean[] visit = new boolean[101];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit[0] = true;
        visit[1] = true;

        for (int i = 0; i < 101; i++) {
            map[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!visit[100]) {
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                int p = queue.poll();
                for (int i = 1; i <= 6; i++) {
                    if(p + i > 100 || visit[p+i])continue;
                    int a = map[p + i];
                    queue.offer(a);
                    visit[p+i] = true;
                    visit[a] = true;
                    map[p+i] = cnt;
                    map[a] = cnt;
                }
            }
        }
        System.out.println(map[100]);
    }
}