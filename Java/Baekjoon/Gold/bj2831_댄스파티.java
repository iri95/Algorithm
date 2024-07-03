package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2831_댄스파티 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] man = new int[N];
        int[] woman = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) man[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) woman[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(man);
        Arrays.sort(woman);
        // 양수 시작 인덱스
        int m = Arrays.binarySearch(man, 0) * (-1) - 1;
        int w = Arrays.binarySearch(woman, 0) * (-1) - 1;
        int count = 0;
        // 키작은 여성 선호
        int wIndex = N - 1;
        for (int i = 0; i < m; i++) {
            int manAb = man[i] * (-1);
            while(wIndex >= w && manAb <= woman[wIndex]) wIndex--;
            if (wIndex < w) break;
            count++;
            wIndex--;
        }

        // 키 큰 여자 선호
        wIndex = w - 1;
        for (int i = m; i < N; i++) {
            while(wIndex >= 0 && man[i] >= woman[wIndex] * (-1)) wIndex--;
            if (wIndex < 0) break;
            count++;
            wIndex--;
        }
        System.out.println(count);
    }
}
