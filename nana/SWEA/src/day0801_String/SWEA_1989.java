package day0801_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_1989 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T;tc++) {
			String word = br.readLine().trim();
			int result = isPalindrome(word)? 1 : 0;
			System.out.println("#" + tc +" "+ result);
			
		}	
			
	}
	
	public static boolean isPalindrome(String word) {
		int length = word.length();
		for(int i=0;i<length/2;i++){
			if(word.charAt(i) != word.charAt(length-1-i)){
				return false;
			}
		}return true;	
	}
}
