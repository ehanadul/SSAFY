package day0806_Stack;

import java.util.Scanner;

public class SWEA_1217 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextLine(); 
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine(); 

			System.out.println("#" + tc + " " + pow(N, M));
		}
		sc.close();
	}
	
	private static int pow(int N, int M) {
		if(M == 0 || N == 1) {
			return 1;
		}
		return N*pow(N, M-1);
	}
	
}
