package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19236_청소년상어 {
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[4][4];
        int[][] fishes = new int[17][3]; // 좌표 2개, 방향
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                fishes[num] = new int[]{i, j, d};
                map[i][j] = num;
            }
        }
        System.out.println(dfs(0, 0, fishes, map));
    }

    private static int dfs(int y, int x, int[][] fishes, int[][] map){
        int[][] cloneMap = new int[4][4];
        int[][] cloneFish = new int[17][3];
        for (int i = 0; i < 4; i++) cloneMap[i] = map[i].clone();
        for (int i = 0; i < 17; i++) cloneFish[i] = fishes[i].clone();

        // 상어가 물고기를 잡아 먹는다.
        cloneFish[map[y][x]][2] = -1; // 물고기가 죽음을 의미
        cloneMap[y][x] = -1; // 상어의 위치

        // 물고기 이동
        for (int i = 1; i < 17; i++) {
            if(cloneFish[i][2] == -1) continue;
            for (int j = 0; j < 8; j++) {
                int d = (cloneFish[i][2] + j) % 8;
                int ny = cloneFish[i][0] + dy[d];
                int nx = cloneFish[i][1] + dx[d];
                if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || cloneMap[ny][nx] == -1) continue;

                // 물고기 이동
                int temp = cloneMap[ny][nx];
                cloneMap[ny][nx] = i;
                cloneMap[cloneFish[i][0]][cloneFish[i][1]] = temp;

                cloneFish[temp][0] = cloneFish[i][0];
                cloneFish[temp][1] = cloneFish[i][1];
                cloneFish[i][0] = ny;
                cloneFish[i][1] = nx;
                cloneFish[i][2] = d;

                break;
            }
        }

        // 상어가 물고기를 먹는 경우를 dfs로 계산하고 최댓값을 찾아낸다.
        int max = 0;
        cloneMap[y][x] = 0;
        int d = fishes[map[y][x]][2];
        for (int i = 1; i <= 3; i++) {
            int ny = y + dy[d] * i;
            int nx = x + dx[d] * i;
            if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || cloneMap[ny][nx] == 0) continue;
            max = Math.max(max, dfs(ny, nx, cloneFish, cloneMap));
        }

        return map[y][x] + max;
    }
}