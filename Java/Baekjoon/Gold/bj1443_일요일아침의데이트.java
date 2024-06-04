package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://velog.io/@lifeisbeautiful/%EB%B0%B1%EC%A4%80-1445%EB%B2%88-%EC%9D%BC%EC%9A%94%EC%9D%BC-%EC%95%84%EC%B9%A8%EC%9D%98-%EB%8D%B0%EC%9D%B4%ED%8A%B8-Java
public class bj1443_일요일아침의데이트 {
    static class Node implements Comparable<Node> {
        int y;
        int x;
        int trash;
        int side;

        public Node(int y, int x, int trash, int side) {
            this.y = y;
            this.x = x;
            this.trash = trash;
            this.side = side;
        }

        public int compareTo(Node node) {
            if (this.trash == node.trash) return this.side - node.side;
            return this.trash - node.trash;
        }
    }

    static int N, M;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        int sy = 0;
        int sx = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    sy = i;
                    sx = j;
                }
            }
        }

        visited[sy][sx] = true;
        pq.add(new Node(sy, sx, 0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int y = node.y;
            int x = node.x;
            int t = node.trash;
            int s = node.side;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (map[ny][nx] == 'g') pq.add(new Node(ny, nx, t + 1, s));
                else if (map[ny][nx] == 'F') {
                    System.out.println(t + " " + s);
                    return;
                } else if (isSideTrash(ny, nx)) pq.add(new Node(ny, nx, t, s + 1));
                else pq.add(new Node(ny, nx, t, s));
            }
        }
    }

    static boolean isSideTrash(int y, int x) {
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (map[ny][nx] == 'g') result = true;
        }
        return result;
    }
}
