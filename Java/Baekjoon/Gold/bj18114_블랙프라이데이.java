package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj18114_블랙프라이데이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i] == C) {
                System.out.println(1);
                return;
            }
        }
        Arrays.sort(list);
        int s = 0;
        int e = N - 1;
        while (s < e) {
            int two = list[s] + list[e];
            if (two == C) {
                System.out.println(1);
                return;
            } else if (two > C) e--;
            else {
                for (int i = s + 1; i < e; i++) {
                    int three = two + list[i];
                    if (three > C) break;
                    else if (three == C) {
                        System.out.println(1);
                        return;
                    }
                }
                s++;
            }
        }
        System.out.println(0);
    }
}
