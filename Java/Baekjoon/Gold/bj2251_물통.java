package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2251_물통 {
    static int A, B, C;
    static boolean[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[C + 1][C + 1];
        dfs(0, 0);
        StringBuffer sb = new StringBuffer();
        for (int i = C; i >= 0; i--) {
            if(map[0][i]) sb.append(C - i + " ");
        }
        System.out.println(sb);

    }
    static void dfs(int a, int b){
        if(map[a][b])return;
        map[a][b] = true;
        int rest = C - a - b;
        // C 이동
        if(b + rest <= B) {
            dfs(a, b + rest);
        }else{
            dfs(a, B);
        }
        if(a + rest <= A){
            dfs(a + rest, b);
        }else{
            dfs(A, b);
        }
        // B 이동
        if(a + b <= A){
            dfs(a + b, 0);
        }else {
            dfs(A, (a + b) - A);
        }
        dfs(a, 0);

        // A 이동
        if (a + b <= B) {
            dfs(0, a + b);
        }else{
            dfs((a + b) - B, B);
        }
        dfs(0, b);
    }
}
