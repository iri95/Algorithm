package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj1365_꼬인전깃줄 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        List<Integer> result = new ArrayList<>();
        result.add(list[0]);
        for (int i = 1; i < N; i++) {
            if (list[i] > result.get(result.size() - 1)) result.add(list[i]);
            else result.set((Collections.binarySearch(result, list[i]) + 1) * (-1), list[i]);
        }
        System.out.println(N - result.size());
    }
}
