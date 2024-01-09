package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj2141_우체국 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<long[]> list = new ArrayList<>();
        long personSum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            list.add(new long[]{a, b});
            personSum += b;
        }
        Collections.sort(list, (o1, o2) ->{
            return (int) (o1[0] - o2[0]);
        });
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += list.get(i)[1];
            if((personSum + 1)/2 <= result) {
                System.out.println(list.get(i)[0]);
                break;
            }
        }
    }
}
