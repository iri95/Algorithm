package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bj2204_도비의난독증테스트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) return;
            String[] list = new String[n];
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                list[i] = br.readLine();
                map.put(list[i].toLowerCase(), list[i]);
                list[i] = list[i].toLowerCase();
            }
            Arrays.sort(list);
            System.out.println(map.get(list[0]));
        }
    }
}
