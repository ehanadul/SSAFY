package day0905;

import java.util.Arrays;
import java.util.Scanner;

public class 프림01_반복문 {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();//정점의 번호 0번부터 시작
		int E = sc.nextInt();//간선의 수
		
		//인접행렬 방식으로
		int[][] adjArr = new int[V][V];
		
		for(int i =0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W; //무향
					
			
		}//입력 끝
		
		
		//방문 쳌
		boolean[] visited = new boolean[V];
		int[] p = new int[V];
		int[] dist = new int[V];
		
		//프림 제1장 : 초기화!
		for(int i =0; i<V; i++) {
			p[i] = -1; // 0번 정점도 사용하니까
			dist[i] = INF;
		}
		
		
//		Arrays.fill(dist, 987654321); // 멋은 있음, but 똑같음

		//프림 제2장 : 시작 정점을 결정
		dist[0] = 0;
		
		//프림 제 3장 : 가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문 쳌 / 갱신
		for(int i = 0; i<V-1; i++) { //V번 돌아도 괜찮아~
			int min = INF;
			int idx = -1;
			//방문하지 않았으면서 자장 작은 값 가져와
			for(int j =0; j<V; j++) {
				if(!visited[j] && dist[j]<min){
					min = dist[j];
					idx = j;
				}
			}// 해당 반복문이 종료가 되면... idx는 가장 작은 값을 가지고 잇어(방문x)
			visited[idx] = true;//방문처리
			
			//방문하지 않았고 갱신할 수 있으면 갱신해 (idx)
			for(int j =0; j<V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx; //필요차
				}
			}
		}//끝
		
		
		int ans =0;
		for(int i = 0; i<V;i++) {
			ans += dist[i];
		}
		
		System.out.println(ans);
	}
}
