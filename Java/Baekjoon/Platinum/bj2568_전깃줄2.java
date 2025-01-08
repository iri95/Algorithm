package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2568_전깃줄2 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxA = 0;
        int[] A = new int[500_001];
        int[] cnt = new int[500_001];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maxA = Math.max(a, maxA);
            A[a] = b;
        }
        for (int i = 1; i <= maxA; i++) {
            if (A[i] == 0) continue;
            if (list.isEmpty() || A[i] > list.get(list.size() - 1)) {
                list.add(A[i]);
                cnt[i] = list.size();
            } else {
                int index = binarySearch(A[i]);
                cnt[i] = index + 1;
                list.set(index, A[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(N - list.size()).append("\n");

        int index = list.size();
        list.clear();
        for (int i = maxA; i > 0; i--) {
            if (cnt[i] == index) {
                list.add(i);
                index--;
                if (index == 0) break;
            }
        }

        for (int i = 1; i <= maxA; i++) {
            if (A[i] == 0) continue;
            if (!list.contains(i)) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int n) {
        int s = 0;
        int e = list.size() - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (list.get(mid) >= n) e = mid;
            else s = mid + 1;
        }
        return e;
    }
}
