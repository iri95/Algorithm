package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj17837_새로운게임2 {
    static int N, K;
    static boolean end = false;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map; // 0 : 흰색, 1 : 빨간색, 2 : 파란색
    static List<int[]> list;
    static List<Integer>[][] mapList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        mapList = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                mapList[i][j] = new ArrayList<>();
            }
        }
        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new int[]{y - 1, x - 1, d - 1});
            mapList[y - 1][x - 1].add(i);
        }
        int cnt = 0;
        while (cnt <= 1000 && !end) {
            cnt++;
            for (int i = 0; i < list.size(); i++) {
                int y = list.get(i)[0];
                int x = list.get(i)[1];
                int d = list.get(i)[2];
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 2) {
                    list.get(i)[2] = d / 2 == 0 ? (d + 1) % 2 : 2 + (d + 1) % 2;
                    ny = y + dy[list.get(i)[2]];
                    nx = x + dx[list.get(i)[2]];
                    doubleBlue(i, y, x, ny, nx);
                    continue;
                }
                if (map[ny][nx] == 0) white(i, y, x, ny, nx);
                else if (map[ny][nx] == 1) red(i, y, x, ny, nx);
            }
        }
        if (cnt > 1000) System.out.println(-1);
        else System.out.println(cnt);
    }

    static void white(int index, int y, int x, int ny, int nx) {
        int number = mapList[y][x].indexOf(index);
        for (int i = number; i < mapList[y][x].size(); i++) {
            mapList[ny][nx].add(mapList[y][x].get(i));
        }
        for (int i = mapList[y][x].size() - 1; i >= number; i--) {
            list.get(mapList[y][x].get(i))[0] = ny;
            list.get(mapList[y][x].get(i))[1] = nx;
            mapList[y][x].remove(i);
        }
        if (mapList[ny][nx].size() >= 4) end = true;
    }

    static void red(int index, int y, int x, int ny, int nx) {
        int number = mapList[y][x].indexOf(index);
        for (int i = mapList[y][x].size() - 1; i >= number; i--) {
            mapList[ny][nx].add(mapList[y][x].get(i));
            list.get(mapList[y][x].get(i))[0] = ny;
            list.get(mapList[y][x].get(i))[1] = nx;
            mapList[y][x].remove(i);
        }
        if (mapList[ny][nx].size() >= 4) end = true;
    }

    static void doubleBlue(int index, int y, int x, int ny, int nx) {
        if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 2) return;
        if (map[ny][nx] == 1) red(index, y, x, ny, nx);
        else if (map[ny][nx] == 0) white(index, y, x, ny, nx);
    }
}
