package day0807_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SWEA_7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc =1; tc<=T;tc++) {
			String[] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);	
		
		
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			
			
			for(int i =1; i <=N; i++) {
				q1.offer(i);
			}
			for(int j =1; j <=M; j++) {
				q2.offer(j);
			}
			
			Map<Integer, Integer> sumFrequency = new HashMap<>();
			
			while (!q1.isEmpty()) {
                int card1 = q1.poll();
                for (int j = 1; j <= M; j++) { 
                    int sum = card1 + j; 
                    sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
                }
            }
			
			int max =0;
			for(int frequency : sumFrequency.values()) {
				if(frequency > max) {
					max = frequency;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<Integer, Integer> entry : sumFrequency.entrySet()) {
                if (entry.getValue() == max) {
                    sb.append(entry.getKey()).append(" ");
                }
            }
			
			System.out.printf("#%d %s%n", tc, sb.toString().trim());
		}
	}
}
