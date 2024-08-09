package day0808_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_2805 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
            	String line = br.readLine();
                for (int j = 0; j < N; j++) {
                	 farm[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
            int profit = calculate(farm, N);
            System.out.printf("#%d %d\n", t, profit);
        }
    }

    private static int calculate(int[][] farm, int N) {
        int profit = 0;
        int mid = N / 2; 

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(mid - i) + Math.abs(mid - j) <= mid) {
                    profit += farm[i][j];
                }
            }
        }

        return profit;
    }
}
