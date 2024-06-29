package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1525_퍼즐 {
    static String result = "123456780";
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) start.append(st.nextToken());
        }
        if (start.toString().equals(result)) {
            System.out.println(0);
            return;
        }
        set.add(start.toString());
        System.out.println(bfs(start.toString()));
    }

    static int bfs(String start) {
        Queue<String> q = new ArrayDeque<>();
        q.add(start);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size-- > 0) {
                String str = q.poll();
                int index = str.indexOf('0');
                int y = index / 3;
                int x = index % 3;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny > 2 || nx < 0 || nx > 2) continue;
                    int next = ny * 3 + nx;
                    char a = str.charAt(next);
                    String nextStr = str.replace(a, '9');;
                    nextStr = nextStr.replace('0', a);
                    nextStr = nextStr.replace('9', '0');
                    if (set.contains(nextStr)) continue;
                    if (nextStr.equals(result)) return count;
                    q.add(nextStr);
                    set.add(nextStr);
                }
            }
        }
        return -1;
    }
}
