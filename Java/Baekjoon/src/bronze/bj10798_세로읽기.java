package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10798_세로읽기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String a = br.readLine();
            for (int j = 0; j < a.length(); j++) {
                map[i][j] = a.charAt(j);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(map[j][i] == 0)continue;
                System.out.print(map[j][i]);
            }
        }
    }
}
