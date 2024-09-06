package day0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	//3289. 서로소 집합
	
	static int T,n,m;
	
	static int[] parent;
	static int[] rank;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parent = new int[n + 1];
            rank = new int[n + 1];
			
			for(int i=0; i<n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
                int operation = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (operation == 0) { // 합집합
                    union(a, b);
                }else if (operation == 1) {// 연산
                	if(find(a) == find(b)) sb.append(1);
                	else sb.append(0);
                }
			}
			sb.append("\n");
			System.out.print("#"+tc+" ");
			System.out.print(sb.toString());
		}
		
	}


	private static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			if(rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			}else if(rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			}else {
				 parent[rootY] = rootX;
	             rank[rootX]++;
			}
		}
		
	}


	private static int find(int x) {
		if(parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x]; //
	}
	
	
	
}
