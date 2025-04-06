package Gold;

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
/* GPT가 최적화해준 코드
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        // 명령을 저장할 스택 (최대 2*K개)
        int size = 2 * K;
        int[] type = new int[size];  // 1: 오름차순, -1: 내림차순
        int[] pos = new int[size];   // 해당 명령의 끝 인덱스
        int top = -1;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1; // 오름차순
            int B = Integer.parseInt(st.nextToken()) - 1; // 내림차순

            // 오름차순 명령 처리
            while (top >= 0 && pos[top] <= A) top--;
            type[++top] = 1;
            pos[top] = A;

            // 내림차순 명령 처리
            while (top >= 0 && pos[top] <= B) top--;
            type[++top] = -1;
            pos[top] = B;
        }

        // 유효한 정렬 구간: 0 ~ pos[0]
        int end = pos[0] + 1;
        // 영향을 받는 구간만 복사 후 정렬
        int[] sortedRegion = Arrays.copyOf(arr, end);
        Arrays.sort(sortedRegion);

        // 두 포인터: left는 가장 작은 값, right는 가장 큰 값의 인덱스
        int left = 0, right = end - 1;

        // 명령에 따라 정렬된 값을 재배치
        int cmdIdx = 0;       // 현재 명령 인덱스 (스택의 맨 아래부터 사용)
        for (int i = pos[0]; i >= 0; i--) {
            // 다음 명령 구간에 도달하면 모드를 갱신
            if (cmdIdx + 1 <= top && i == pos[cmdIdx + 1]) {
                cmdIdx++;
            }
            // 오름차순 모드(1)인 경우, 오른쪽(최대값)에서 채워 넣으면 왼쪽으로 역순 배치되어 오름차순이 됨
            if (type[cmdIdx] == 1) {
                arr[i] = sortedRegion[right--];
            } else { // 내림차순 모드(-1)인 경우, 왼쪽(최소값)에서 채워 넣으면 역순 배치되어 내림차순이 됨
                arr[i] = sortedRegion[left++];
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
 */