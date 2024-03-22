import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숫자블록 {
    static int N, M, P, K, min;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][][] visit; // 3차원 배열로 방문 여부를 관리

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][P]; // P로 나눴을 때 방문 여부를 확인하기 위해 3차원 배열로 선언

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[0][0][map[0][0] % P] = true; // 시작 블록을 방문처리
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, map[0][0] % P});
        int count = 0;
        while(!queue.isEmpty() && count < M * N + 1){
            int size = queue.size();
            count++;
            while(size-- > 0) {
                int[] p = queue.poll();
                int y = p[0];
                int x = p[1];
                int sum = p[2];
                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    int nextSum = (sum * 10 + map[ny][nx]) % P;
                    if(visit[ny][nx][nextSum]) continue;
                    visit[ny][nx][nextSum] = true;
                    if(nextSum == K){
                        System.out.print(count);
                        return;
                    }
                    queue.add(new int[] {ny, nx, nextSum});
                }
            }
        }
        System.out.print(-1);
    }
}