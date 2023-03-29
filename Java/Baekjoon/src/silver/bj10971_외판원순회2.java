package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10971_외판원순회2 {
	static int N, min;
	static int[][] map;
	static boolean[] visit;
	static int[] tgt;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	visit = new boolean[N];
    	tgt = new int[N];
    	min = Integer.MAX_VALUE;
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	perm(0);
    	System.out.println(min);
    }
    static void perm(int tgtIdx) {
    	if(tgtIdx == N) {
    		int k = 0;
    		for (int i = 0; i < N; i++) {
    			if(i == N - 1) {
    				if(map[tgt[i]][tgt[0]] == 0) {
    					k =  Integer.MAX_VALUE;
        				break;
    				}
    				k += map[tgt[i]][tgt[0]];
    				break;
    			}
    			
    			if( map[tgt[i]][tgt[i+1]] == 0) {
    				k =  Integer.MAX_VALUE;
    				break;
    			}
				k += map[tgt[i]][tgt[i+1]];
				
			}
    		min = Math.min(k, min);
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
			if(visit[i])continue;
    		visit[i] = true;
			tgt[tgtIdx] = i;
			perm(tgtIdx + 1);
			visit[i] = false;
		}
    }
}