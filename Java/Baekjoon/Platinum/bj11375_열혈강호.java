package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 이분매칭 https://loosie.tistory.com/643
public class bj11375_열혈강호 {
    static int N, M;
    static int[] num;
    static boolean[] check;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        num = new int[M + 1];
        int count = 0;
        check = new boolean[M + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            if (dfs(i)) count++;
        }
        System.out.println(count);

    }

    static boolean dfs(int number) {
        for (int p : list[number]) {
            if (!check[p]) {
                check[p] = true;
                if (num[p] == 0 || dfs(num[p])) {
                    num[p] = number;
                    return true;
                }
            }
        }
        return false;
    }
}
