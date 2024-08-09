package day0807_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {
	
	static int T = 10;
	static int[] num = new int[8];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i=0; i <8;i++) {
				 queue.add(Integer.parseInt(st.nextToken()));
			}
		
			int decrement =1;
			
			while (true) {
				int num = queue.poll();
				num -= decrement;
				
				if(num <= 0) {
					queue.add(0);
					break;
				}
				queue.add(num);
				decrement = (decrement%5) +1;
				
			}
			
			System.out.print("#" + tc + " ");
			for(int num : queue) {
				System.out.print(num + " ");
			}
			System.out.println();

		}
	}
}
