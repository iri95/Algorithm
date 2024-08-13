package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2352_반도체설계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        list.add(arr[1]);
        for (int i = 2; i <= n; i++) {
            int value = Collections.binarySearch(list, arr[i]) * (-1) - 1;
            if (value == list.size()) list.add(arr[i]);
            else list.set(value, arr[i]);
        }
        System.out.println(list.size());
    }
}
