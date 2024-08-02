package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj2002_추월 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] in = new String[N];
        String[] out = new String[N];
        for (int i = 0; i < N; i++)
            in[i] = br.readLine();
        for (int i = 0; i < N; i++)
            out[i] = br.readLine();

        Set<String> set = new HashSet<>();
        int count = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (set.contains(in[i])) continue;
            while (true) {
                if (out[index].equals(in[i])) {
                    index++;
                    break;
                }else{
                    set.add(out[index++]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
