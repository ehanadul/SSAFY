package day0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_1486 {
//1486. 장훈이의 높은 선반
	static int T, N, B;
	static int[] height;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			height = new int[N];
			
			st = new StringTokenizer(br.readLine().trim());
			for(int i =0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int minHeight = Integer.MAX_VALUE; // B 이상 최소 높이
			
			//조합
			for(int k =1; k <(1<<N); k++) {
				int sum =0;
				for(int j=0; j<N; j++) {
					if((k & (1<< j)) != 0) {
						sum += height[j];
					}
				}
				
				
				if(sum >= B) {
					minHeight = Math.min(minHeight, sum); 
				}
			}
			
			sb.append("#").append(tc).append(" ").append(minHeight - B).append("\n");
			
			
		}
		System.out.print(sb.toString());
		br.close();
	}
	
}
