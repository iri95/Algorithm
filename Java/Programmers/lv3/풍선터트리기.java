package lv3;

import java.util.*;

public class 풍선터트리기 {
    // 양쪽의 풍선의 최소값이 둘다 자기보다 작을경우 못살아남음
    // 처음 마지막은 살아남음
    public static int solution(int[] a) {
        int answer = 2;
        int before = a[0];
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 2; i < a.length; i++) {
            queue.offer(a[i]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == queue.peek()) queue.poll();
            set.add(a[i]);
            while (true) {
                if(set.contains(queue.peek())) queue.poll();
                else break;
            }
            if (a[i] > before && a[i] > queue.peek()) continue;
            before = Math.min(before, a[i]);
            answer++;
        }
        return answer;
    }
    /*
    한쪽에서만 봤을 때 최소값이기만 하면 가능 -> 양방향 찾아냄
    int answer = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<a.length;i++){
            min1=Math.min(min1,a[i]);
            min2=Math.min(min2,a[a.length-1-i]);
            hs.add(min1);
            hs.add(min2);

        }
        return hs.size();
     */

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, -1, -5})); // 3
        System.out.println(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33})); // 6
    }
}
