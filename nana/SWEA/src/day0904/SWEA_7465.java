package day0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_7465 {
	//7465. 창용 마을 무리의 개수
	static int T, N, M,a,b;
	static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		T = Integer.parseInt(br.readLine());
		
		
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			makeSet();
			
			for(int i =0; i<M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				
				int pa = findSet(a);
				int pb = findSet(b);
				
				if(pa != pb)
					union(pa, pb);
			
			}
		
		
			Set<Integer> result = new HashSet<>();
				for (int i = 1; i < N+1; i++) {
					result.add(findSet(i)); 
		           }
				
			System.out.printf("#%d %d\n",tc, result.size());
		}
		
	}

	private static void makeSet() {
		for(int i =1; i<N+1; i++) {
			p[i] = i;
		}
		
	}
	
	private static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
			return p[x];
	}
	
	private static void union(int px, int py) {
		
		p[px] = py;
	}
	
}
