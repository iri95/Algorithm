package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj12014_주식 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append("\n");
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
            for (int i = 1; i < N; i++) {
                int a = Integer.parseInt(st.nextToken());
                int size = list.size();
                if (list.get(size - 1) < a) list.add(a);
                else {
                    int bi = Collections.binarySearch(list, a);
                    if (bi >= 0) continue;
                    bi = bi * (-1) - 1;
                    list.set(bi, a);
                }
            }
            if (list.size() >= K) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
