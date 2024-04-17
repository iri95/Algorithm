package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj13144_ListOfUniqueNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1;
        long answer = 0;
        Set<Integer> set = new HashSet<>();
        set.add(list[0]);
        while (start < N) {
            while (end < N && !set.contains(list[end])) {
                set.add(list[end]);
                end++;
            }
            answer += set.size();
            set.remove(list[start]);
            start++;
        }
        System.out.println(answer);
    }
}
