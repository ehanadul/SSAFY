package day0731_Array;

import java.util.Scanner;

public class SWEA_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			//2차원 배열 만들고
			//왼쪽 위에서부터 숫자를 채워나가기
			//N*N번 만큼 반복이 일어남
			
			
			int cnt = 0;
			int r = 0; //0,0 부터 출발
			int c = 0; //우(0)하(1)좌(2)상(3)
			int d = 0;
			
			while(cnt++ <N*N) { // for 문 사용해도 됨 
				System.out.println(cnt);
				// 1. 현재좌표(r,c)에다가 cnt를 넣는다.
				arr[r][c] = cnt;
				// 2. 1칸 이동 (바로 다음칸 좌표 만들기)
				//갈 수 없다면 => 방향을 바꾸어서 다음 좌표 만들기
				//갈 수 있다면 => (현재 방향 유지) 다음 좌표 만들기
				
				if(d==0) {// 2-1. 오른쪽 방향이라면, 갈 수 있는지(경계 벗어나거나 이미 숫자가 채워져 있는지)
					if(c == N-1 || c < N-1 && arr[r][c+1] != 0) {
						d=(d+1)%4; // 그 다음 방향으로 가기            
						r++; //다음 좌표는 아래 
					}else
						c++;
				}
				else if(d==1) {// 2-1. 아래쪽 방향이라면, 갈 수 있는지(경계 벗어나거나 이미 숫자가 채워져 있는지)
					if(c == N-1 || c < N-1 && arr[r][c+1] != 0) {
						d=(d+1)%4; // 그 다음 방향으로 가기            
						r++; //다음 좌표는 아래 
					}else
						c++;
				}
				else if(d==2) {// 2-1. 왼쪽 방향이라면, 갈 수 있는지(경계 벗어나거나 이미 숫자가 채워져 있는지)
					if(c == N-1 || c < N-1 && arr[r][c+1] != 0) {
						d=(d+1)%4; // 그 다음 방향으로 가기            
						r++; //다음 좌표는 아래 
					}else
						c++;
				}
				else if(d==3) {// 2-1. 위쪽 방향이라면, 갈 수 있는지(경계 벗어나거나 이미 숫자가 채워져 있는지)
					if(c == N-1 || c < N-1 && arr[r][c+1] != 0) {
						d=(d+1)%4; // 그 다음 방향으로 가기            
						r++; //다음 좌표는 아래 
					}else
						c++;
				}
			}
			
			
		}
		
		
		
	}
}
