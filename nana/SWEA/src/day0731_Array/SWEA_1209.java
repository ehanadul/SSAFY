package day0731_Array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_1209 {
    private static final int SIZE = 100;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine()); 
            int[][] arr = new int[SIZE][SIZE];
 
            for (int i = 0; i < SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); 
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken()); 
                }
            }
 
            int max = maxSum(arr); 
            System.out.println("#" + t + " " + max); 
        }
    }
 
    static int maxSum(int[][] arr) {
        int max = 0;
 
 
        for (int i = 0; i < SIZE; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < SIZE; j++) {
                rowSum += arr[i][j];        // 행
                columnSum += arr[j][i];     // 열 
            }
            max = Math.max(max, Math.max(rowSum, columnSum));
        }
 
        // 대각선
        int diagonalSumA = 0;
        int diagonalSumB = 0;
        for (int i = 0; i < SIZE; i++) {
            diagonalSumA += arr[i][i];          
            diagonalSumB += arr[i][SIZE - 1 - i]; 
        }
 
     
        max = Math.max(max, Math.max(diagonalSumA, diagonalSumB));
 
        return max;
    }
}