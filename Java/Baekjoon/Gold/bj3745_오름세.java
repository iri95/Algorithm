package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj3745_오름세 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String input = null;
        List<Integer> list;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input.trim());
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
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
            sb.append(list.size()).append("\n");
        }
        System.out.println(sb);
    }
}
