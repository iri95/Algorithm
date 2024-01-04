package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj22868_산책samll {
    static int N, M;
    static boolean[] visitAll;
    static boolean[][] map;

    static class Wolk {
        int point;
        boolean[] visit;
        int value;

        public Wolk() {
        }

        public Wolk(boolean[] visit, int point) {
            this.visit = visit;
            this.point = point;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visitAll = new boolean[N + 1];
        map = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            map[p1][p2] = true;
            map[p2][p1] = true;
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[N + 1];
        visitAll[S] = true;

        Wolk route1 = bfs(visit, S, E);
        int result = route1.value;

        route1.visit[S] = false;
        visitAll = route1.visit.clone();
        Wolk route2 = bfs(route1.visit, E, S);
        result += route2.value;

        System.out.println(result);
    }

    static Wolk bfs(boolean[] visit, int startPoint, int endPoint) {
        Wolk result = new Wolk();
        Queue<Wolk> queue = new ArrayDeque<>();
        queue.offer(new Wolk(visit, startPoint));
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                Wolk p = queue.poll();
                for (int i = 1; i <= N; i++) {
                    if (visitAll[i]) continue;
                    if (map[p.point][i]) {
                        if (i == endPoint) {
                            Wolk a = new Wolk(p.visit, i);
                            a.value = cnt;
                            return a;
                        }
                        visitAll[i] = true;
                        boolean[] v = p.visit.clone();
                        v[i] = true;
                        queue.offer(new Wolk(v, i));
                    }
                }
            }
        }
        return result;
    }
}
