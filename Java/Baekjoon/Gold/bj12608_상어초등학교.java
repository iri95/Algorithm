package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj12608_상어초등학교 {
    static int N;
    static List<Integer>[] list;
    static Queue<Integer> queue;
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        list = new ArrayList[N * N + 1];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            list[num] = new ArrayList<>();
            queue.offer(num);
            for (int j = 0; j < 4; j++) {
                list[num].add(Integer.parseInt(st.nextToken()));
            }
        }
        while (!queue.isEmpty()) {
            int num = queue.poll();
            favorite(num);
        }
        System.out.println(count());
    }

    // 주변 좋아하는 학생이 많은 칸 -> 여러개 일경우 maxEmpty 실행
    static void favorite(int num) {
        int max = 0;
        ArrayList<int[]> site = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0)continue;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= N || ny < 0 || nx >= N || nx < 0) continue;
                    if (list[num].contains(map[ny][nx])) cnt++;
                }
                if (max == cnt) site.add(new int[]{i, j});
                else if (max < cnt) {
                    max = cnt;
                    site.clear();
                    site.add(new int[]{i, j});
                }
            }
        }
        if (site.size() == 1) {
            int y = site.get(0)[0];
            int x = site.get(0)[1];
            map[y][x] = num;
        } else maxEmpty(site, num);
    }

    // 인접한 칸 중에서 비어있는 칸이 많은 칸 -> 여러개일 경우
    // 행의 번호가 가장 작은 칸 -> 열의 번호가 가장 작은 칸
    static void maxEmpty(List<int[]> site, int num) {
        List<int[]> emptySite = new ArrayList<>();
        int max = 0;
        int size = site.size();
        int index = 0;
        while (size > index) {
            int cnt = 0;
            int y = site.get(index)[0];
            int x = site.get(index)[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny >= N || ny < 0 || nx >= N || nx < 0) continue;
                if (map[ny][nx] == 0) cnt++;
            }
            if (max == cnt) emptySite.add(new int[]{y, x});
            else if (max < cnt) {
                max = cnt;
                emptySite.clear();
                emptySite.add(new int[]{y, x});
            }
            index++;
        }
        int y = emptySite.get(0)[0];
        int x = emptySite.get(0)[1];
        map[y][x] = num;
    }

    static int count() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = map[i][j];
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= N || ny < 0 || nx >= N || nx < 0) continue;
                    if (list[num].contains(map[ny][nx])) cnt++;
                }
                if (cnt == 1) result++;
                else if (cnt == 2) result += 10;
                else if (cnt == 3) result += 100;
                else if (cnt == 4) result += 1000;
            }
        }
        return result;
    }
}
