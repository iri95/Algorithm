package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj2866_문자열잘라내기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringBuilder[] str = new StringBuilder[C];
        for (int i = 0; i < C; i++) {
            str[i] = new StringBuilder();
        }
        for (int i = 0; i < R; i++) {
            String a = br.readLine();
            for (int j = 0; j < C; j++) {
                str[j].append(a.charAt(j));
            }
        }
        Set<String> set = new HashSet<>();
        int start = 0;
        int end = R;
        while (start < end) {
            int mid = (start + end) / 2;
            boolean same = false;
            for (int i = 0; i < C; i++) {
                String a = str[i].substring(mid + 1, R);
                if (set.contains(a)) {
                    same = true;
                    break;
                } else set.add(a);
            }
            if (same) end = mid;
            else start = mid + 1;
        }
        System.out.println(end);
    }
}
