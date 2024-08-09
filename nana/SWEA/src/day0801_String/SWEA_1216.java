package day0801_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine()); 
            String[][] board = new String[100][100];

            
            for (int i = 0; i < 100; i++) {
                board[i] = br.readLine().split("");
            }

            int max = 0;

            
            max = Math.max(max, palindrome(board, true));
            max = Math.max(max, palindrome(board, false));

            System.out.printf("#%d %d%n", t, max);
        }
    }

    private static int palindrome(String[][] board, boolean isHorizontal) {
        int maxLength = 0;

        for (int len = 1; len <= 100; len++) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j <= 100 - len; j++) {
                    boolean isPalindrome = true;
                    for (int k = 0; k < len / 2; k++) {
                        String start, end;
                        if (isHorizontal) {
                            start = board[i][j + k];
                            end = board[i][j + len - 1 - k];
                        } else {
                            start = board[j + k][i];
                            end = board[j + len - 1 - k][i];
                        }
                        if (!start.equals(end)) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        maxLength = Math.max(maxLength, len);
                    }
                }
            }
        }
        
        return maxLength;
    }
}
