package day0902;

import java.util.Scanner;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// V, E 의 갯수를 준다
		int V = sc.nextInt(); //정점의 개수( 0 OR 1로 시작을 한다.)
		int E = sc.nextInt(); // 간선의 개수

		
		int[][] adjArr = new int[V][V];//만약 시작정점이 1이라면 [V+1][V+1]
		
		for(int i = 0; i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();//두개의 정점이 주어진다.
			int W = sc.nextInt();//가중치가 있다면 값은 3개
			
			adjArr[A][B] = 1; // 가중치가 없다면 1을 있다면 W를 저장하겠다.
//			adjArr[B][A] = 1;// 만약의 무향이라면 반대의 경우도 같이 작성을 해주어애 힘
			
//			adjArr[A][B] = adjArr[B][A] = W; // 한 줄 작성
			
			
			
			
			
			
		}//E개의 간선을 입력 받을 반복문
	}
}
