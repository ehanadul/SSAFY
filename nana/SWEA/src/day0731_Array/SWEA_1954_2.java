package day0731_Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SWEA_1954_2 {
	  public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine().trim());
	
	        for (int tc = 1; tc <= T; tc++) {
	            int N = Integer.parseInt(br.readLine().trim());
	            int[][] arr = new int[N][N];
	
	            int cnt = 0;
	            int r = 0;
	            int c = 0;
	            int d = 0;
	
	            int[] dr = {0, 1, 0, -1};
	            int[] dc = {1, 0, -1, 0};
	
	            while (cnt++ < N * N) {
	                arr[r][c] = cnt;
	
	                int nr = r + dr[d]; 
	                int nc = c + dc[d]; 
	
	                if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) {
	                    d = (d + 1) % 4; 
	                    nr = r + dr[d];
	                    nc = c + dc[d];
	                }
	                r = nr;
	                c = nc;                
	            }
	
	            System.out.println("#" + tc);
	            for (r = 0; r < N; r++) {
	                for (c = 0; c < N; c++) {
	                    System.out.print(arr[r][c] + " ");
	                }
	                System.out.println();
	            }
	        }
	  }
}

