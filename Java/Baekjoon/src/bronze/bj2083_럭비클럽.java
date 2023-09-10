package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2083_럭비클럽 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(age == 0)break;
            sb.append(name + " ");
            if (age > 17 || weight >= 80) {
                sb.append("Senior");
            }else {
                sb.append("Junior");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
