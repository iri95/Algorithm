package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj13415_정렬게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        Deque<int[]> deque = new ArrayDeque<>(); // int[0] = 1, -1 오름차순, 내림차순 , int[1] = 숫자
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1; // 오름차순
            int B = Integer.parseInt(st.nextToken()) - 1; // 내림차순

            while (!deque.isEmpty() && deque.peekLast()[1] <= A) deque.pollLast();
            deque.add(new int[]{1, A});
            while (!deque.isEmpty() && deque.peekLast()[1] <= B) deque.pollLast();
            deque.add(new int[]{-1, B});
        }

        List<Integer> temp = list.subList(0, deque.peekFirst()[1] + 1);
        Collections.sort(temp);
        Deque<Integer> d = new ArrayDeque<>(temp);
        int[] arr = deque.pollFirst();
        boolean up = arr[0] == 1;
        int index = arr[1];
        while (!d.isEmpty()) {
            if (!deque.isEmpty() && index == deque.peekFirst()[1]) {
                arr = deque.pollFirst();
                up = arr[0] == 1;
                index = arr[1];
            }

            if (up)
                list.set(index--, d.pollLast());
            else
                list.set(index--, d.pollFirst());
        }

        StringBuilder sb = new StringBuilder();
        for (int num : list)
            sb.append(num).append(" ");

        System.out.println(sb);
    }
}
