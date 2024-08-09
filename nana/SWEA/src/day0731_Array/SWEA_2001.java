package day0731_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_2001 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]); 
            int M = Integer.parseInt(nm[1]); 

            int[][] arr = new int[N][N]; 

      
            for (int r = 0; r < N; r++) {
                String[] input = br.readLine().split(" ");
                for (int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(input[c]); 
                }
            }

            int max = 0; 

     
            for (int r = 0; r <= N - M; r++) {
                for (int c = 0; c <= N - M; c++) {
                    int sum = 0; 

                    
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            sum += arr[r + i][c + j]; 
                        }
                    }

                 
                    if (sum > max) {
                        max = sum;
                    }
                }
            }

     
            System.out.println("#" + test_case + " " + max);
        }
        br.close();
    }
}
