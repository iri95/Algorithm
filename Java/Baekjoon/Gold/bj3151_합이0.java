package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj3151_합이0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()) + 1000_0;
        }
        int[] count = new int[2000_1];
        for (int i = 0; i < N; i++) {
            count[list[i]]++;
        }
        Arrays.sort(list);
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int target = 30000 - list[i];
            count[list[i]]--;
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                if (list[start] + list[end] == target) {
                    if (list[start] == list[end]) cnt += (long) count[list[start]] * (count[list[start]] - 1) / 2;
                    else cnt += (long) count[list[start]] * count[list[end]];
                    start += count[list[start]];
                    end -= count[list[end]];
                } else if (list[start] + list[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(cnt);

    }
}
