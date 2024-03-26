package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3190_뱀 {
    static int N, K, L, answer, dir = 0;
    static int[] p = {0, 0};
    static int[] dy = {0, 1, 0, -1}; // dy, dx 는 오른쪽부터 시계방향으로
    static int[] dx = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visit;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        visit[0][0] = true;
        queue.add(new int[]{0, 0});
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
        }
        L = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            // 이동
            for (int j = count; j < cnt; j++) {
                if(!move()){
                    System.out.println(answer);
                    return;
                }
            }
            if (direction == 'D') dir = (dir + 1) % 4;
            else dir = (dir + 3) % 4;
            count = cnt;
        }
        while (move()){}
        System.out.println(answer);
    }

    static boolean move(){
        answer++;
        p[0] += dy[dir];
        p[1] += dx[dir];
        if (p[0] < 0 || p[0] >= N || p[1] < 0 || p[1] >= N || visit[p[0]][p[1]]) {
            return false;
        }
        if (map[p[0]][p[1]] == 1) {
            map[p[0]][p[1]] = 0;
            queue.add(new int[]{p[0], p[1]});
        }else{
            int[] tail = queue.poll();
            visit[tail[0]][tail[1]] = false;
            queue.add(new int[]{p[0], p[1]});
        }
        visit[p[0]][p[1]] = true;
        return true;
    }
}
