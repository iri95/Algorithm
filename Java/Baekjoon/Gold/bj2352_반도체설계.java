package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2352_반도체설계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = list.size();
            while (s < e) {
                int mid = (s + e) / 2;
                if (list.get(mid) < value) s = mid + 1;
                else e = mid;
            }
            if (s == list.size()) list.add(value);
            else list.set(s, value);
        }
        System.out.println(list.size());
    }
}
