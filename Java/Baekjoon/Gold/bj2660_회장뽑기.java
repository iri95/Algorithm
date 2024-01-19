package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2660_회장뽑기 {
    static int N;
    static int[] point;
    static boolean[][] friend;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        point = new int[N + 1];
        friend = new boolean[N + 1][N + 1];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1)break;
            friend[a][b] = true;
            friend[b][a] = true;
        }
        int min = 51;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            point[i] = getPoint(i);
            if (min > point[i]) {
                list.clear();
                list.add(i);
                min = point[i];
            }else if(point[i] == min) list.add(i);
        }
        System.out.println(min + " " + list.size());
        for (int k:list) {
            System.out.print(k + " ");
        }
    }
    private static int getPoint(int n) {
        int cnt = 1; // 현재 친구의 수
        int count = 0; // 몇점인가?
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(n);
        visit[n] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                int p = queue.poll();
                for (int i = 1; i < N + 1; i++) {
                    if (visit[i] || i == p) continue;
                    if (friend[p][i]) {
                        queue.add(i);
                        visit[i] = true;
                        cnt++;
                    }
                }
            }
            if (cnt >= N)break;
        }
        return count;
    }
}
