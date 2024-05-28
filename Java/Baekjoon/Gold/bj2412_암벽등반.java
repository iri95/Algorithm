package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2412_암벽등반 {
    static class Point{
        int x;
        int y;
        boolean visited;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Map<Integer, List<Point>> map = new HashMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (!map.containsKey(x)) map.put(x, new ArrayList<>());
            map.get(x).add(new Point(x, y));
        }
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        int cnt = 0;
        int ans = -1;
        bfs : while(!q.isEmpty()){
            cnt++;
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                for (int nx = p.x - 2; nx <= p.x + 2 ; nx++) {
                    if (!map.containsKey(nx)) continue;
                    for (Point np : map.get(nx)) {
                        if (np.visited || np.y > p.y + 2 || np.y < p.y - 2) continue;
                        np.visited = true;
                        q.add(np);
                        if (np.y >= T) {
                            ans = cnt;
                            break bfs;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
