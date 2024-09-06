package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2817 {
	
	static boolean[] sel;
	static int N, K;
	static int[] arr;
	static int count = 0;

	// 2817. 부분 수열의 합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim()); 
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().trim().split(" ");
			N = Integer.parseInt(input[0]); 
			K = Integer.parseInt(input[1]); 
			
			sel = new boolean[N];
			arr = new int[N];
			
			input = br.readLine().trim().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(input[i]); 
			}
			
			count = 0; 
			sumNumber(0);
			
			System.out.printf("#%d %d\n", tc, count); 
		}
		br.close();
	}
    
    public static void sumNumber(int idx) {
    	if (idx == N) {
    		int sum = 0;
    		for (int i = 0; i < N; i++) {
    			if (sel[i]) {
    				sum += arr[i];
    			}
    		}
			if (sum == K && sum > 0) {
				count++;
			}
			return;
    	}
    	
    	sel[idx] = true;
    	sumNumber(idx + 1);
    	
    	sel[idx] = false;
    	sumNumber(idx + 1);
    }
}
