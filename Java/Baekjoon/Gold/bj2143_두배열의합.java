package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2143_두배열의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        A[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        B[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
        }
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listA.add(A[i]);
            for (int j = 0; j < i; j++) {
                listA.add(A[i] - A[j]);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (map.containsKey(B[i])) {
                map.put(B[i], map.get(B[i]) + 1);
            } else {
                map.put(B[i], 1);
            }
            for (int j = 0; j < i; j++) {
                if (map.containsKey(B[i] - B[j])) {
                    map.put(B[i] - B[j], map.get(B[i] - B[j]) + 1);
                } else {
                    map.put(B[i] - B[j], 1);
                }
            }
        }
        Collections.sort(listA);
        long cnt = 0;

        for (int i = 0; i < listA.size(); i++) {
            int target = T - listA.get(i);
            if (map.containsKey(target)) {
                cnt += (long) map.get(target);
            }
        }
        System.out.println(cnt);

    }
}
