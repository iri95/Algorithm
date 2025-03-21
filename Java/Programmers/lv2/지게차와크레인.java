package lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 지게차와크레인 {
    public int solution(String[] storage, String[] requests) {
        int ylen = storage.length;
        int xlen = storage[0].length();
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};
        int[][] arr = new int[ylen + 2][xlen + 2];

        for(int i = 1; i <= ylen; i++){
            for(int j = 1; j <= xlen; j++){
                arr[i][j] = storage[i-1].charAt(j - 1) - 'A' + 1;
            }
        }

        for (String request : requests) {
            int c = request.charAt(0) - 'A' + 1;
            if (request.length() == 1) {
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{0, 0});
                boolean[][] visited = new boolean[ylen + 2][xlen + 2];
                visited[0][0] = true;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int ny = cur[0] + dy[k];
                        int nx = cur[1] + dx[k];
                        if (ny < 0 || ny >= ylen + 2 || nx < 0 || nx >= xlen + 2 || visited[ny][nx]) continue;
                        visited[ny][nx] = true;
                        if (arr[ny][nx] == 0) queue.add(new int[]{ny, nx});
                        else if (arr[ny][nx] == c) arr[ny][nx] = 0;
                    }
                }
            } else {
                for (int i = 1; i <= ylen; i++) {
                    for (int j = 1; j <= xlen; j++) {
                        if (arr[i][j] == c) arr[i][j] = 0;
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 1; i <= ylen; i++){
            for(int j = 1; j <= xlen; j++){
                if(arr[i][j] != 0) answer++;
            }
        }

        return answer;
    }
}
