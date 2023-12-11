package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-12886-%EB%8F%8C-%EA%B7%B8%EB%A3%B9-java
public class bj12886_돌그룹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static boolean[][] visit = new boolean[1501][1501];
    static int sum, avg;
    static boolean possible = false;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        sum = a + b + c;
        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }
        avg = sum / 3;

        find(a, b);
        find(b, c);
        find(a, c);

        System.out.println(possible ? 1 : 0);
    }

    static private void find(int a, int b) {
        if (a == avg && b == avg) possible = true;
        if (possible || a == b || visit[a][b] || visit[b][a]) return;
        visit[a][b] = true;

        int c = sum - a - b;
        if (a < b) {
            b -= a;
            a *= 2;
        } else {
            a -= b;
            b *= 2;
        }

        find(a, b);
        find(b, c);
        find(a, c);
    }
}