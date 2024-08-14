package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2565_전깃줄 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        List<Integer> dpList = new ArrayList<>();
        dpList.add(list.get(0)[1]);
        for (int i = 1; i < N; i++) {
            int value = list.get(i)[1];
            if (value > dpList.get(dpList.size() - 1)) dpList.add(value);
            else {
                int k = Math.abs(Collections.binarySearch(dpList, value) + 1);
                dpList.set(k, value);
            }
        }
        System.out.println(N - dpList.size());
    }
}
