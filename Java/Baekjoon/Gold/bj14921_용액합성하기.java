package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14921_용액합성하기 {
    static int N;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        System.out.println(twoPointer());
    }

    static int twoPointer() {
        int start = 0;
        int end = N - 1;
        int answer = 200_000_001;
        while (start < end) {
            if (list[start] + list[end] == 0) {
                answer = 0;
                break;
            } else if (Math.abs(list[start] + list[end]) < Math.abs(answer)) {
                answer = list[start] + list[end];
                if (answer < 0) {
                    start++;
                } else {
                    end--;
                }
            } else if (list[start] + list[end] < 0) {
                start++;
            } else {
                end--;
            }
        }
        return answer;
    }
}
