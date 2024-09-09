package day0909;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1267 {
	
	static int T, V, E;
	static int A,B;
	static int[][] adjArr;
	static int[] degree;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T =10;
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjArr = new int[V+1][V+1];
			degree = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<E; i++) {
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				
				adjArr[A][B] = 1;
				degree[B]++;
			}//입력 끝
			
			
			queue = new LinkedList<>();
			
			for(int i=1; i<V+1; i++) {
				if(degree[i] == 0) {
					queue.add(i);
				}
			}
			
			sb.append("#").append(tc).append(" ");
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr).append(" ");
				
				for(int i =1; i<V+1; i++) {
					if(adjArr[curr][i] == 1) {
						degree[i]--;
						adjArr[curr][i] = 0;
						
						if(degree[i]==0) {
							queue.add(i);
						}
					}
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
	}
}
