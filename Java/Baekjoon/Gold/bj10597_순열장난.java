package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10597_순열장난 {
    static int n, cnt;
    static String result;
    static StringBuilder str;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringBuilder(br.readLine());
        n = str.length();
        cnt = n <= 9 ? n : (n - 9) / 2 + 9;
        visited = new boolean[cnt + 1];
        sol(0, "");
        System.out.println(result);
    }

    private static void sol(int sIndex, String string) {
        if (sIndex >= n) {
            result = string;
            return;
        }

        int a = str.charAt(sIndex) - '0';
        if (a == 0) return;
        if (!visited[a]) {
            visited[a] = true;
            sol(sIndex + 1, string + a + " ");
            visited[a] = false;
        }

        if (sIndex >= n - 1) return;
        int two = a * 10 + (str.charAt(sIndex + 1) - '0');
        if (two <= cnt && !visited[two]) {
            visited[two] = true;
            sol(sIndex + 2, string + two + " ");
            visited[two] = false;
        }
    }
}
