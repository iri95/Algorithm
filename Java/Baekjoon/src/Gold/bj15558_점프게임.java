package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj15558_점프게임 {
    static int N, k;
    static boolean[][] map;
    static boolean result;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new boolean[2][N];
        dx = new int[]{1, -1, k, k};
        for (int i = 0; i < 2; i++) {
            String a = br.readLine();
            for (int j = 0; j < N; j++) {
                if(a.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }
        bfs();
        if(result){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if(ny < 0 || ny >= 2 || nx <= cnt || (nx < N && !map[ny][nx]))continue;
                    if(nx == N-1 && map[ny][N-1]){
                        result = true;
                        return;
                    }else if(nx == N-1 && !map[ny][N-1]){
                        continue;
                    }
                    if(nx >= N) {
                        result = true;
                        return;
                    }
                    map[ny][nx] = false;
                    queue.offer(new int[]{ny, nx});
                }
            }
            cnt++;
        }
    }
}
