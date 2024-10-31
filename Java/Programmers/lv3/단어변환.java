package lv3;

import java.util.*;

public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = begin.length();
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new ArrayDeque<>();
        q.add(begin);
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();
            while (size-- > 0) {
                String now = q.poll();
                for (int i = 0; i < words.length; i++) {
                    if (visited[i]) continue;
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if (now.charAt(j) == words[i].charAt(j)) count++;
                    }
                    if (count == n - 1) {
                        q.add(words[i]);
                        visited[i] = true;
                        if (words[i].equals(target)) return answer;
                    }
                }
            }
        }
        return 0;
    }
}
