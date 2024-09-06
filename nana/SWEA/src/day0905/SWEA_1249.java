package day0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1249 {
//1249. [S/W 문제해결 응용] 4일차 - 보급로
	
	static int T, N;
	static int[][] map,dist;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	
	static class Node{
		int x, y, cost;
		
		Node(int x, int y, int cost){
			this.x =x;
			this.y=y;
			this.cost=cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i<N; i++) {
				String line = br.readLine();
				for(int j =0; j<N; j++) {
					map[i][j] = line.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}//입력 끝
			
			
			dijkstra();
			
			sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		
		
		System.out.println(sb.toString());
//		br.close();
	}


	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
		pq.offer(new Node(0,0,map[0][0])); //시작점
		dist[0][0] =0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			int x = current.x;
			int y = current.y;
			int cost = current.cost;
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			for(int i =0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				  if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					  int newCost = cost + map[nx][ny];
					  if(newCost < dist[nx][ny]) {
						  dist[nx][ny] = newCost;
						  pq.offer(new Node(nx,ny,newCost));//우선순위 큐 추가
					  }
				  }
				
			}
		}
	}
	
}
