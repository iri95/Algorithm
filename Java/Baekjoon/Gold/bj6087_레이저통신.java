package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj6087_레이저통신 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        char[][] map = new char[H][W];
        int[][] count = new int[H][W];
        boolean[][][] visit = new boolean[H][W][4];
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};
        int max = 10_001;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            Arrays.fill(count[i], max);
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'C') list.add(new int[]{i, j, -1, -1});
            }
        }
        int[] start = list.get(0);
        int[] end = list.get(1);
        count[start[0]][start[1]] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] == '*' || count[ny][nx] < p[2] || (count[ny][nx] == p[2] && i != p[3] || (count[ny][nx] == p[2] && visit[ny][nx][i]))) continue;
                    visit[ny][nx][i] = true;
                    if (p[3] == -1) {
                        queue.offer(new int[]{ny, nx, 0, i});
                        count[ny][nx] = 0;
                    } else {
                        if (i != p[3]) {
                            queue.offer(new int[]{ny, nx, p[2] + 1, i});
                            count[ny][nx] = p[2] + 1;
                        } else {
                            queue.offer(new int[]{ny, nx, p[2], i});
                            count[ny][nx] = p[2];
                        }
                    }
                }
            }
        }
        System.out.println(count[end[0]][end[1]]);

    }
}
