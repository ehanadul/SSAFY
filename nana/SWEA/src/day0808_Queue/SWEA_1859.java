package day0808_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_1859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
//			String[] input = br.readLine().split(" ");
//			int[] num =new int[N];
//	        for (int i = 0; i < N; i++) {
//	            num[i] = Integer.parseInt(input[i]);
//	        }
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int[] num = new int[N];
			for(int i = 0; i <N;i++) {
					num[i] = Integer.parseInt(st.nextToken());
			}
		    int maxPrice = 0; 
            long profit = 0; 
 
             
            for(int i = N - 1; i >= 0; i--){
                if(num[i] > maxPrice){
                    maxPrice = num[i];
                }
                profit += maxPrice - num[i];
            }
 
            System.out.printf("#%d %d\n" ,tc, profit); 
		
        }br.close();
	}
}
