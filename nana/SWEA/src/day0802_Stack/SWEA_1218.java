package day0802_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {

	static int T = 10;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc =1; tc<=10; tc++) {
			int lenght = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			int isValid = check(input) ? 1 : 0 ;
			System.out.println("#" + tc + " " + isValid);
		}
					
	}				
					
	private static boolean check(String input){
		Stack<Character> stack = new Stack<>();
		
		for(char bracket : input.toCharArray()) {
			
			if(bracket =='(' || bracket == '[' || bracket == '{' || bracket == '<') {
				stack.push(bracket);
			}
			else if (bracket ==')' || bracket == ']' || bracket == '}' || bracket == '>') {
				if(stack.isEmpty()) {
					return false;
				}
				
				char top = stack.pop();
				
				if (!isMatching(top,bracket)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	private static boolean isMatching(char open, char close) {
		return (open == '(' && close == ')') ||
				(open == '[' && close == ']') ||
				(open == '{' && close == '}') ||
				(open == '<' && close == '>');
	}					
}
