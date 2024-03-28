package lv3;


import java.util.ArrayDeque;
import java.util.Deque;
// https://school.programmers.co.kr/questions/41064
// k개의 배열 안에서 max 값을 찾아야 함.
public class 징검다리건너기 {
    static class Data{
        int index;
        int value;

        private Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static int solution(int[] stones, int k) {
        int answer = 200_000_001;
        Deque<Data> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && dq.peekLast().value < stones[i])  dq.removeLast();
            dq.addLast(new Data(i, stones[i]));
        }
        answer = Math.min(dq.peekFirst().value, answer);
        for (int i = k; i < stones.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst().index <= i - k) dq.removeFirst();
            while (!dq.isEmpty() && dq.peekLast().value < stones[i]) dq.removeLast();
            dq.addLast(new Data(i, stones[i]));
            answer = Math.min(dq.peekFirst().value, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
}
