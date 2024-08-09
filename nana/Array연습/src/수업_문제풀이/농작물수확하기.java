package 수업_문제풀이;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 농작물수확하기 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input (11).txt"));
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <=T; tc++) {
			
			int N = sc.nextInt();
			int [][] board = new int[N][N];
			
			for(int r=0; r<N;r++) {
				String line = sc.next();
				for(int c=0;c<N;c++) {
					board[r][c] = line.charAt(c) -'0';
				}
			}
			int sum =0;
			int start = N/2;
			int end = N/2;
			
			for(int r =0; r<N;r++) {
				for(int c =start; c<end;c++) {
					sum += board[r][c];
				}
				if(r<N/2) {
					start--;
					end++;
				}
			}
			System.out.printf("#%d %d\n", tc,sum);
		}
		
	}
}
