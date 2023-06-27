package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2668%EB%B2%88-%EC%88%AB%EC%9E%90%EA%B3%A0%EB%A5%B4%EA%B8%B0-%EC%9E%90%EB%B0%94Java
public class bj2668_숫자고르기 {
    static int N, number;
    static int[] list;
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < N + 1; i++) {
            number = i;
            visit[i] = true;
            dfs(i);
            visit[i] = false;
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void dfs(int num) {
        if (list[num] == number) result.add(number);

        if (!visit[list[num]]) {
            visit[list[num]] = true;
            dfs(list[num]);
            visit[list[num]] = false;
        }
    }
}