package lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 배달 {
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];
        int[] result = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] p : road) {
            map[p[0]][p[1]] = map[p[0]][p[1]] != 0 ? Math.min(map[p[0]][p[1]], p[2]) : p[2];
            map[p[1]][p[0]] = map[p[1]][p[0]] != 0 ? Math.min(map[p[1]][p[0]], p[2]) : p[2];
        }
        Arrays.fill(result, 500_001);
        result[1] = 0;
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int p = queue.poll()[0];
            visit[p] = true;
            for (int i = 1; i < N + 1; i++) {
                if (visit[i] || map[p][i] == 0) continue;
                if (result[i] > result[p] + map[p][i]) {
                    result[i] = result[p] + map[p][i];
                    queue.offer(new int[]{i, result[i]});
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (result[i] <= K) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
        System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
}
