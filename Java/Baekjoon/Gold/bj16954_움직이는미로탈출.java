package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16954_움직이는미로탈출 {
    static int[] dy = {0, 0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dx = {0, 1, -1, 0, 1, -1, 0, 1, -1};
    static boolean[][] block = new boolean[8][8];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String a = br.readLine();
            for (int j = 0; j < 8; j++) {
                if(a.charAt(j) == '#')block[i][j] = true;
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{7, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 9; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny < 0 || nx < 0 || ny > 7 || nx > 7 || block[ny][nx]) continue;
                    if (ny - 1 >= 0 && block[ny - 1][nx]) continue;
                    if (ny == 0 && nx == 7) {
                        System.out.println(1);
                        return;
                    }
                    queue.offer(new int[]{ny, nx});
                }
            }
            for (int i = 7; i >= 0; i--) {
                for (int j = 0; j < 8; j++) {
                    if (i == 7) {
                        block[7][j] = false;
                    } else if (block[i][j]) {
                        block[i][j] = false;
                        block[i + 1][j] = true;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
