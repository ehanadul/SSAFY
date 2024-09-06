package day0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112 {
//2112. [모의 SW 역량테스트] 보호 필름
	
	
	static int T, D, W, K,result;
	static int[][] film;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력 끝
			
			result = K;
			
			if(K == 1) {
				result = 0;
			}else {
				dfs(0,0);
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}


	private static void dfs(int depth, int chemicalCount) {
		
		if(chemicalCount > result) return;
		if(depth==D) {
			if(performTest()) {
				result = Math.min(result, chemicalCount);
			}
			return;
		}
		
		int[] origRow = film[depth].clone(); 
        dfs(depth + 1, chemicalCount); 
        
        Arrays.fill(film[depth], 0); 
        dfs(depth + 1, chemicalCount + 1); 
        
        Arrays.fill(film[depth], 1); 
        dfs(depth + 1, chemicalCount + 1); 
        
        film[depth] = origRow;
		
		
	}


	private static boolean performTest() {
		for(int w =0; w<W; w++) {
			boolean isColumnPass = false;
			int count = 0;
			int curProperty = -1;
			for(int d =0; d<D; d++) {
				if(curProperty == film[d][w]) {
					count++;
				}else {
					curProperty = film[d][w];
					count=1;
				}
				
				if(count >= K) {
					isColumnPass = true;
					break;
				}
			}
			if(!isColumnPass)return false;
			
		}
		return true;
		
	}
	
}
