package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14003_가장긴증가하는부분수열5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int[] index = new int[N];
        List<Integer> result = new ArrayList<>();
        list[0] = Integer.parseInt(st.nextToken());
        result.add(list[0]);
        for (int i = 1; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i] > result.get(result.size() - 1)) {
                result.add(list[i]);
                index[i] = result.size() - 1;
            } else {
                int k = Collections.binarySearch(result, list[i]);
                if (k < 0) {
                    result.set((k + 1) * (-1), list[i]);
                    index[i] = (k + 1) * (-1);
                } else {
                    index[i] = k;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = result.size();
        sb.append(size).append("\n");
        int[] answer = new int[size--];
        for (int i = N - 1; i >= 0; i--) {
            if (size == index[i]) answer[size--] = list[i];
            if (size < 0) break;
        }
        for (int i = 0; i < result.size(); i++) sb.append(answer[i]).append(" ");
        System.out.print(sb);
    }
}