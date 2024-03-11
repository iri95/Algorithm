package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj6137_문자열생성 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] list = new char[N];
        for (int i = 0; i < N; i++) {
            list[i] = br.readLine().charAt(0);
        }
        int start = 0;
        int end = N - 1;
        StringBuilder T = new StringBuilder();
        while(start < end){
            boolean where = false;
            if (list[start] == list[end]) {
                int s = start + 1;
                int e = end - 1;
                while (s < e) {
                    if (list[s] == list[e]) {
                        s++;
                        e--;
                        continue;
                    }
                    if (list[s] > list[e]) {
                        where = true;
                        break;
                    } else break;
                }
                T.append(where ? list[end--] : list[start++]);
                continue;
            }
            T.append(list[start] < list[end] ? list[start++] : list[end--]);
        }
        T.append(list[start]);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 80 == 0) {
                T.insert(i + count, "\n");
                count++;
            }
        }
        System.out.println(T);
    }
}
