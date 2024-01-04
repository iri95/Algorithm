package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9946_단어퍼즐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            String str1 = br.readLine();
            String str2 = br.readLine();
            if (str1.equals("END") && str2.equals("END")) break;
            if (str1.chars().sorted().collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString().equals(str2.chars().sorted().collect(StringBuilder::new,
                                    StringBuilder::appendCodePoint,
                                    StringBuilder::append)
                            .toString())) {
                sb.append("Case " + cnt + ": same").append("\n");
            } else {
                sb.append("Case " + cnt + ": different").append("\n");
            }
            cnt++;
        }
        System.out.println(sb);
    }
}
