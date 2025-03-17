package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11658_구간합구하기3 {
    static int[][] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i][j - 1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                int sum = 0;
                for (int x = x1; x <= x2; x++)
                    sum += dp[x][y2] - dp[x][y1 - 1];

                sb.append(sum).append("\n");
            } else {
                int c = Integer.parseInt(st.nextToken());
                int dif = c - arr[x1][y1];
                for (int y = y1; y <= n; y++)
                    dp[x1][y] += dif;

                arr[x1][y1] = c;
            }
        }

        System.out.println(sb.toString());
    }
}

/* 2차원 세그먼트 트리 - 1104ms, 188356KB
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    // 2차원 세그먼트 트리: 각 차원마다 최대 4배 크기로 할당 (문제 조건에 맞게 N+1 사용)
    static int[][] seg;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 세그먼트 트리 배열 크기: 행과 열 모두 4*(N+1)
        seg = new int[4 * (N + 1)][4 * (N + 1)];
        buildX(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 0) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                // diff 계산 후 배열과 세그먼트 트리 업데이트
                int diff = c - arr[x][y];
                arr[x][y] = c;
                updateX(1, 1, N, x, y, diff);
            } else {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int res = queryX(1, 1, N, x1, x2, y1, y2);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    // 행 구간에 대한 세그먼트 트리 빌드
    static void buildX(int nodeX, int startX, int endX) {
        if (startX == endX) {
            // 단일 행일 경우 해당 행의 열 세그먼트 트리를 빌드
            buildY(nodeX, startX, endX, 1, 1, N);
        } else {
            int mid = (startX + endX) / 2;
            buildX(nodeX * 2, startX, mid);
            buildX(nodeX * 2 + 1, mid + 1, endX);
            buildY(nodeX, startX, endX, 1, 1, N);
        }
    }

    // 열 구간에 대한 세그먼트 트리 빌드
    static void buildY(int nodeX, int startX, int endX, int nodeY, int startY, int endY) {
        if (startY == endY) {
            if (startX == endX) {
                seg[nodeX][nodeY] = arr[startX][startY];
            } else {
                seg[nodeX][nodeY] = seg[nodeX * 2][nodeY] + seg[nodeX * 2 + 1][nodeY];
            }
        } else {
            int mid = (startY + endY) / 2;
            buildY(nodeX, startX, endX, nodeY * 2, startY, mid);
            buildY(nodeX, startX, endX, nodeY * 2 + 1, mid + 1, endY);
            seg[nodeX][nodeY] = seg[nodeX][nodeY * 2] + seg[nodeX][nodeY * 2 + 1];
        }
    }

    // 열에 대한 구간 합 쿼리
    static int queryY(int nodeX, int nodeY, int startY, int endY, int y1, int y2) {
        if (y2 < startY || endY < y1) return 0;
        if (y1 <= startY && endY <= y2) return seg[nodeX][nodeY];
        int mid = (startY + endY) / 2;
        return queryY(nodeX, nodeY * 2, startY, mid, y1, y2)
                + queryY(nodeX, nodeY * 2 + 1, mid + 1, endY, y1, y2);
    }

    // 행과 열에 대한 구간 합 쿼리
    static int queryX(int nodeX, int startX, int endX, int x1, int x2, int y1, int y2) {
        if (x2 < startX || endX < x1) return 0;
        if (x1 <= startX && endX <= x2) return queryY(nodeX, 1, 1, N, y1, y2);
        int mid = (startX + endX) / 2;
        return queryX(nodeX * 2, startX, mid, x1, x2, y1, y2)
                + queryX(nodeX * 2 + 1, mid + 1, endX, x1, x2, y1, y2);
    }

    // 열에 대한 업데이트: 해당 열의 세그먼트 트리 갱신
    static void updateY(int nodeX, int startX, int endX, int nodeY, int startY, int endY, int x, int y, int diff) {
        if (y < startY || endY < y) return;
        if (startY == endY) {
            if (startX == endX) {
                seg[nodeX][nodeY] += diff;
            } else {
                seg[nodeX][nodeY] = seg[nodeX * 2][nodeY] + seg[nodeX * 2 + 1][nodeY];
            }
        } else {
            int mid = (startY + endY) / 2;
            updateY(nodeX, startX, endX, nodeY * 2, startY, mid, x, y, diff);
            updateY(nodeX, startX, endX, nodeY * 2 + 1, mid + 1, endY, x, y, diff);
            seg[nodeX][nodeY] = seg[nodeX][nodeY * 2] + seg[nodeX][nodeY * 2 + 1];
        }
    }

    // 행에 대한 업데이트: 업데이트한 행을 포함하는 모든 노드에 대해 열 세그먼트 트리 업데이트
    static void updateX(int nodeX, int startX, int endX, int x, int y, int diff) {
        if (x < startX || x > endX) return;
        if (startX != endX) {
            int mid = (startX + endX) / 2;
            updateX(nodeX * 2, startX, mid, x, y, diff);
            updateX(nodeX * 2 + 1, mid + 1, endX, x, y, diff);
        }
        updateY(nodeX, startX, endX, 1, 1, N, x, y, diff);
    }
}

 */

/* 2차원 펜윅 트리 - 840ms, 131428KB
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static long[][] fenw; // 펜윅 트리 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        fenw = new long[N + 1][N + 1];

        // 초기 배열 입력 및 펜윅 트리 구축
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                update(i, j, arr[i][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 0) { // 점 업데이트
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int diff = c - arr[x][y];
                arr[x][y] = c;
                update(x, y, diff);
            } else { // 구간 합 쿼리
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                long res = query(x2, y2) - query(x1 - 1, y2) - query(x2, y1 - 1) + query(x1 - 1, y1 - 1);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    // (x, y) 위치에 diff만큼 값을 추가하는 함수
    static void update(int x, int y, int diff) {
        for (int i = x; i <= N; i += (i & -i)) {
            for (int j = y; j <= N; j += (j & -j)) {
                fenw[i][j] += diff;
            }
        }
    }

    // (1,1)부터 (x,y)까지의 합을 구하는 함수
    static long query(int x, int y) {
        long sum = 0;
        for (int i = x; i > 0; i -= (i & -i)) {
            for (int j = y; j > 0; j -= (j & -j)) {
                sum += fenw[i][j];
            }
        }
        return sum;
    }
}
 */