package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj9238_열쇠 {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map;
    static Queue<int[]> queue = new ArrayDeque<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            List<int[]> startList = new ArrayList<>();
            boolean[][][] visit = new boolean[h][w][27];
            Set<Character> keys = new HashSet<>();
            int answer = 0;
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*') continue;
                    if (i == 0 || j == 0 || i == h -1 || j == w - 1) {
                        startList.add(new int[]{i, j});
                        if (map[i][j] <= 'z' && map[i][j] >= 'a') keys.add((char)(map[i][j] - 32));
                        else if (map[i][j] == '$'){
                            answer++;
                            map[i][j] = '.';
                        }

                    }
                }
            }
            String keyStr = br.readLine().toUpperCase();
            if (!keyStr.equals("0")) {
                for (int i = 0; i < keyStr.length(); i++) {
                    keys.add(keyStr.charAt(i));
                }
            }
            // key의 개수에 차이가 생긴다면 한번 더 각 입구로 bfs 돌리고 변화가 없다면 끝
            while (true) {
                int size = keys.size();
                for (int i = 0; i < startList.size(); i++) {
                    int y = startList.get(i)[0];
                    int x = startList.get(i)[1];
                    if (map[y][x] <= 'Z' && map[y][x] >= 'A' && !keys.contains(map[y][x])) continue;
                    queue.add(startList.get(i));
                    visit[y][x][keys.size()] = true;
                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        for (int j = 0; j < 4; j++) {
                            int ny = p[0] + dy[j];
                            int nx = p[1] + dx[j];
                            if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == '*' || visit[ny][nx][keys.size()]) continue;
                            if (map[ny][nx] <= 'Z' && map[ny][nx] >= 'A' && !keys.contains(map[ny][nx])) continue;
                            if (map[ny][nx] <= 'z' && map[ny][nx] >= 'a') keys.add((char) (map[ny][nx] - 32));
                            if (map[ny][nx] == '$') {
                                answer++;
                                map[ny][nx] = '.';
                            }
                            visit[ny][nx][keys.size()] = true;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
                if (size == keys.size()) break;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
