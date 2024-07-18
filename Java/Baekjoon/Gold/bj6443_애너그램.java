package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj6443_애너그램 {
    static int len;
    static char[] str, chars;
    static int[] cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            cnt = new int[26];
            str = br.readLine().toCharArray();
            len = str.length;
            for (char c : str) cnt[c - 'a']++;
            chars = new char[str.length];
            comb(0);
        }
        System.out.println(sb);
    }

    private static void comb(int index) {
        if (index == len) {
            sb.append(String.valueOf(chars)).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                chars[index] = (char) ('a' + i);
                cnt[i]--;
                comb(index + 1);
                cnt[i]++;
            }
        }
    }
}
