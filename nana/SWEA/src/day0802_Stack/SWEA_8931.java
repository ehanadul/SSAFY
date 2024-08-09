package day0802_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_8931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T;tc++) {
			int K = Integer.parseInt(br.readLine());
			
			
			Stack<Integer> stack = new Stack<>();
			for(int i =0; i<K;i++) {
				int num = Integer.parseInt(br.readLine());
				if(num==0) {
					if(!stack.isEmpty()) {
						stack.pop();
					}
				}else {
					stack.push(num);
				}
			}
			
			int sum =0;
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			
			
			System.out.println("#" + tc +" " + sum);
			
		}
		
	
	}
}
