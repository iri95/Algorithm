import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합성곱연산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] filter = new int[N][N];
        int[][] image = new int[M][M];
        int[][] result = new int[M - N + 1][M - N + 1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                filter[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M - N + 1; i++){
            for(int j = 0; j < M - N + 1; j++){
                for(int y = 0; y < N; y++){
                    for(int x = 0; x < N; x++){
                        result[i][j] += filter[y][x] * image[i+y][x+j];
                    }
                }
            }
            for(int k = 0; k < M - N + 1; k++){
                sb.append(result[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
