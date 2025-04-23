package lv3;
// 이분 탐색으로 어떤 weak에 사람을 배치할 지 찾아낸다.
// 순열을 사용해서 풀어야 할 듯?
public class 외벽점검 {
    static int answer, wLen, dLen;
    static int[] arr, d;
    static boolean[] visited;

    public int solution(int n, int[] weak, int[] dist) {
        answer = 9;
        wLen = weak.length;
        dLen = dist.length;
        d = dist;
        arr = new int[wLen * 2];
        visited = new boolean[dLen];
        for (int i = 0; i < wLen; i++) {
            arr[i] = weak[i];
            arr[i + wLen] = weak[i] + n;
        }

        for (int i = 0; i < wLen; i++)
            sol(i, 0, 0);

        return answer == 9 ? -1 : answer;
    }

    private static void sol(int index, int fCount, int wCount) {
        if (fCount > answer) return;

        if (wCount >= wLen) {
            answer = fCount;
            return;
        }

        for (int i = 0; i < dLen; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int nextIdx = -1;
            int nextDist = arr[index] + d[i];
            int cnt = 0;
            for (int j = index; j < wLen * 2; j++) {
                if (arr[j] > nextDist) {
                    nextIdx = j;
                    break;
                }
                cnt++;
            }
            sol(nextIdx, fCount + 1, wCount + cnt);
            visited[i] = false;
        }
    }
}
