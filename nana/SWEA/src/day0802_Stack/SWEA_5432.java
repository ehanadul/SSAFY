package day0802_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc <=T;tc++) {
			String input = br.readLine();
			int pieces = countPieces(input);
			System.out.println("#" + tc + " " + pieces);
		}
	}
	
	
	private static int countPieces(String input) {
		int pieces =0;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < input.length();i++) {
			char ch = input.charAt(i);
			if(ch == '(') {
				stack.push(ch);
			}else {
				stack.pop();
				if(input.charAt(i-1)=='(') {
					pieces += stack.size();
				}else {
					pieces += 1;
				}
			}
		}
		return pieces;
	}
	
	
}
