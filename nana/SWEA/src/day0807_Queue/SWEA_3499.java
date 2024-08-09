package day0807_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			int half = (N+1)/2;
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			for(int i =0; i<half;i++) {
				q1.add(st.nextToken());
			}
			
			for(int i =half; i<N;i++) {
				q2.add(st.nextToken());
			}
			
			
			StringBuilder sb = new StringBuilder();
			
			while (!q1.isEmpty() || !q2.isEmpty()) {
				if(!q1.isEmpty())
					sb.append(q1.poll()).append(" ");
				
				if(!q2.isEmpty())
					sb.append(q2.poll()).append(" ");
				
			}
			System.out.println("#" + tc + " " + sb);
		}
	}
}
