package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2352_반도체설계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        list.add(arr[1]);
        for (int i = 2; i <= n; i++) {
            int s = 0;
            int e = list.size();
            while (s < e) {
                int mid = (s + e) / 2;
                if (list.get(mid) < arr[i]) s = mid + 1;
                else e = mid;
            }
            if (s == list.size()) list.add(arr[i]);
            else list.set(s, arr[i]);
        }
        System.out.println(list.size());
    }
}
