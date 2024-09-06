package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012 {
//[모의 SW 역량테스트] 요리사
	
	 static int T,R,N,min;
	 static int[][] synergy;
	 static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            R =N/2;
            selected = new boolean[N];
            synergy= new int[N][N];
            min = Integer.MAX_VALUE;
            
            for(int i =0; i < N; i++) {
            	st = new StringTokenizer(br.readLine().trim());
            	 for(int j=0; j< N; j++) {
            		 synergy[i][j] = Integer.parseInt(st.nextToken());
            	 }
            }
            
            combination(0,0);
            System.out.printf("#%d %d\n", tc, min);
        }
        br.close();
	}
	
	
	public static void combination(int idx, int sidx) {
		if(idx==R) {
			int sumA = 0;
			int sumB = 0;
			
			// A음식 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        sumA += synergy[i][j];
                    }
                }
            }
            // B음식
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!selected[i] && !selected[j]) {
                        sumB += synergy[i][j];
                    }
                }
            }
            // 맛 차이 계산
            int diff = Math.abs(sumA - sumB);
            min = Math.min(min, diff); 
            return;
        }
        
        for (int i = sidx; i < N; i++) {
            selected[i] = true; 
            combination(idx + 1, i + 1); // 다음 재료 선택
            selected[i] = false; 
					
		}
	}
}
