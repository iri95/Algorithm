package lv2;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 석유시추 {
    public static int solution(int[][] land) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        boolean[][] visit = new boolean[land.length][land[0].length];
        int index = 0;
        for (int i = 0; i < land[0].length; i++) {
            int cnt = 0;
            List<Integer> visitIndex = new ArrayList<>();
            for (int j = 0; j < land.length; j++) {
                if (visit[j][i]) {
                    if(!visitIndex.contains(land[j][i])) {
                        cnt += list.get(land[j][i]);
                        visitIndex.add(land[j][i]);
                    }
                    continue;
                }
                int count = 0;
                if (land[j][i] == 1){
                    land[j][i] = index;
                    visitIndex.add(index);
                    queue.add(new int[]{j, i});
                    visit[j][i] = true;
                    cnt++;
                    count++;
                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = p[0] + dy[k];
                            int nx = p[1] + dx[k];
                            if (ny < 0 || ny >= land.length || nx < 0 || nx >= land[0].length || visit[ny][nx]) continue;
                            if (land[ny][nx] == 1) {
                                queue.add(new int[]{ny, nx});
                                visit[ny][nx] = true;
                                land[ny][nx] = index;
                                cnt++;
                                count++;
                            }
                        }
                    }
                    list.add(count);
                    index++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}));
    }
}
