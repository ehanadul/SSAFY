package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class SWEA_10726 {
//10726.이진수 표현[D3]
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<T;tc++) {
			Stack<Integer> stack = new Stack<>();
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			int m =M;
			while(m%2<2) {
				if(m%2==0) {
					stack.push(0);
				}else
					stack.push(1);
				
				m=m/2;
			}
			stack.push(m);
			
			
			System.out.println(stack);
		
		}
	}	
}
