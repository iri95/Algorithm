package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class bj1941_소문난칠공주 {
    static int answer = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map = new char[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) map[i] = br.readLine().toCharArray();
        for(int i = 0; i <= 18; i++)
            comb(i, map[i / 5][i % 5] == 'S' ? 1 : 0, 1, new int[]{i, 0, 0, 0, 0, 0, 0});
        System.out.println(answer);
    }

    private static void comb(int p, int sCnt, int cnt, int[] arr) {
        if (cnt == 7) {
            if (sCnt >= 4 && check(arr)) answer++;
            return;
        }
        for (int i = p; i < p + 6; i++) {
            if(i >= 25) break;
            arr[cnt] = i;
            if (map[i / 5][i % 5] == 'S') comb(i + 1, sCnt + 1, cnt + 1, arr);
            else comb(i + 1, sCnt, cnt + 1, arr);
        }
    }

    private static boolean check(int[] arr) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(arr[0]);
        boolean[] visited = new boolean[25];
        visited[arr[0]] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p / 5 + dy[i];
                int nx = p % 5 + dx[i];
                int np = ny * 5 + nx;
                if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || visited[np]) continue;
                visited[np] = true;
                for (int j = 1; j < 7; j++) {
                    if (np == arr[j]) {
                        q.add(np);
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt == 7) return true;
        }
        return false;
    }
}
