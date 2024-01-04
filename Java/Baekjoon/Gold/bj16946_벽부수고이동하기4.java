package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16946_벽부수고이동하기4 {
    static int N, M, cnt;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static List<int[]> zero = new ArrayList<>();
    static List<int[]> one = new ArrayList<>();
    static int[][] map;
    static int[][] group;
    static boolean[][] visit, wall;
    static Map<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        group = new int[N+2][M+2];
        visit = new boolean[N+2][M+2];
        wall = new boolean[N+2][M+2];

        for (int i = 1; i <= N; i++) {
            String array = br.readLine();
            for (int j = 0; j < M; j++) {
                if(array.charAt(j) == '1'){
                    map[i][j+1] = 1;
                    visit[i][j+1] = true;
                    one.add(new int[]{i, j + 1});
                    wall[i][j+1] = true;
                }else{
                    zero.add(new int[] {i, j+1});
                }
            }
        }
        int groupId = 0;
        for (int[] po: zero
             ) {
            groupId++;
            int i = po[0];
            int j = po[1];
            if(visit[i][j])continue;
            cnt = 0;
            dfs(i,j, groupId);
            hashMap.put(groupId, cnt);
        }

        for (int[] po :
                one) {
            Set<Integer> set = new HashSet<>();
            int i = po[0];
            int j = po[1];
            for (int k = 0; k < 4; k++) {
                int ny = i + dy[k];
                int nx = j + dx[k];
                if(ny > N || nx > M || ny <= 0 || nx <= 0 || wall[ny][nx])continue;
                set.add(group[ny][nx]);
            }
            for (int num :
                    set) {
                map[i][j] += hashMap.get(num);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(map[i][j]%10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    // 벽이 아닌 곳의 이동가능한 칸의 개수를 구하고 그룹을 나누는 함수
    static void dfs(int y, int x, int groupId){
        visit[y][x] = true;
        group[y][x] = groupId;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny > N || nx > M || ny <= 0 || nx <= 0 || visit[ny][nx])continue;
            dfs(ny, nx, groupId);
        }
    }
}
