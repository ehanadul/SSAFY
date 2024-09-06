package day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2806 {
	static int T,N;
	static int[] queen; 
    static int count; 
	
    public static void main(String[] args) throws NumberFormatException, IOException  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	T = Integer.parseInt(br.readLine()); 

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); 
            count = 0;
            queen = new int[N]; 
            placeQueens(0, N); 
            System.out.printf("#%d %d%n", tc, count); 
        }
    }

    //dfs
    public static void placeQueens(int row, int n) {
        if (row == n) { // 퀸 n개 모두 배치
            count++; 
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) { // 현재 위치 안전확인
                queen[row] = col; // 퀸 배치
                placeQueens(row + 1, n); // 다음 행 재귀 호출
            }
        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열, 대각선에 있는지 체크
            if (queen[i] == col || Math.abs(queen[i] - col) == Math.abs(i - row)) {
                return false; 
            }
        }
        return true; 
    }
}

