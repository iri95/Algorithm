package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj3107_IPv6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] list = str.split(":");
        String[] answer = new String[8];
        int len = list.length;
        if (len == 8) {
            for (int i = 0; i < 8; i++) answer[i] = change(list[i]);
        } else {
            String non = "0000";
            int m = 8 - len;
            if (list[0].isEmpty()) {
                for (int i = 0; i < m + 2; i++) answer[i] = non;
                for (int i = 2; i < len; i++) answer[i + m] = change(list[i]);
            } else if (str.charAt(str.length() - 1) == ':') {
                for (int i = 0; i < len; i++) answer[i] = change(list[i]);
                for (int i = len; i < 8; i++) answer[i] = non;
            } else {
                boolean visit = false;
                for (int i = 0; i < len; i++) {
                    if (list[i].isEmpty()) {
                        for (int j = i; j <= i + m; j++) answer[j] = non;
                        visit = true;
                    } else {
                        if (visit) answer[i + m] = change(list[i]);
                        else answer[i] = change(list[i]);
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            result.append(answer[i]);
            if (i != 7) result.append(":");
        }
        System.out.println(result);
    }

    private static String change(String a) {
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() < 4) sb.insert(0, "0");
        return sb.toString();
    }
}
