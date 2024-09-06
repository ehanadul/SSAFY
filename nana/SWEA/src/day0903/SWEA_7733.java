package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7733 {
	
	static int T,N,count,MaxCheese;
	static int[][] map;
    static boolean[][] visited;
    static int[] dc = {-1, 0, 0,1};
    static int[] dr = { 0,-1, 1,0};
  
    

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        	T=Integer.parseInt(st.nextToken());
        	
        for(int tc =1; tc<=T; tc++) {
	        
	            st = new StringTokenizer(br.readLine().trim());
	            N = Integer.parseInt(st.nextToken());
	            
	            map = new int[N][N]; 
	            visited = new boolean[N][N];
	           
	
	            for (int i = 0; i < N; i++) {
	                st = new StringTokenizer(br.readLine().trim());
	                for (int j = 0; j < N; j++) {
	                    map[i][j] = Integer.parseInt(st.nextToken());
	                }
	            }
	            
	            MaxCheese = 0;
	            
	            for(int X=0; X<101; X++) {
	            	visited = new boolean[N][N];
	            	count = 0;
	            	
		            for (int i = 0; i < N; i++) {
		                for (int j = 0; j < N; j++) {
		                		
		                    if (!visited[i][j] && map[i][j] > X) {
		                        dfs(i, j, X);
		                        count++;
		                    }
		                }
		            }
		            MaxCheese = Math.max(MaxCheese, count);
	        }
	            System.out.printf("#%d %d\n", tc, MaxCheese);
        }
	}



	private static void dfs(int c, int r, int X) {
		visited[c][r] = true;
        for (int i = 0; i < 4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];

            if (nc < 0 || nr < 0 || nc >= N || nr >= N) continue;
            if (map[nc][nr] > X && !visited[nc][nr])
                dfs(nc, nr, X);
        }
		
	}
}
