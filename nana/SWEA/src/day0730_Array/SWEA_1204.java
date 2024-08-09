package day0730_Array;

import java.util.Scanner;

public class SWEA_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int testNumber = sc.nextInt();
			int[] frequency = new int[101];
			
			
			for(int i=0;i<1000;i++) {
				frequency[sc.nextInt()]++;
			}
			
			
			int mode = -1;
			int maxFrequency = 0;
			
			
			for(int score =0; score <= 100; score++) {
				if(frequency[score] > maxFrequency || 
				  (frequency[score] == maxFrequency && score > mode)) {
					maxFrequency = frequency[score]; 
					mode = score; 
				}
				
			}System.out.println("#" + testNumber + " " + mode);		
		}sc.close();
	}
}
