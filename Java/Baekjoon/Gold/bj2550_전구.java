package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2550_전구 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int[] indexList = new int[N + 1];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st1.nextToken());
            indexList[Integer.parseInt(st2.nextToken())] = i;
        }

        int[] count = new int[N];
        int[] result = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);
        int cnt = 1;
        count[0] = 1;
        result[0] = indexList[list[0]];
        int index = 0;
        for (int i = 1; i < N; i++) {
            if (indexList[list[i]] > result[index]) {
                index++;
                result[index] = indexList[list[i]];
                count[i] = index + 1;
            } else {
                int k = Arrays.binarySearch(result, indexList[list[i]]);
                k = (k + 1) * -1;
                result[k] = indexList[list[i]];
                count[i] = k + 1;
            }
        }
        index++;
        int[] answer = new int[index];
        sb.append(index).append("\n");
        for (int i = N - 1; i >= 0; i--) {
            if (count[i] == index) {
                index--;
                answer[index] = list[i];
            }
        }
        Arrays.sort(answer);
        for (int j : answer) {
            sb.append(j).append(" ");
        }
        System.out.println(sb);
    }
}
