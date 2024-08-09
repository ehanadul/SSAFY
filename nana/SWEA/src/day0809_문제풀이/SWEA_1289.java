package day0809_문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            char[] bit = str.toCharArray(); 
            int cnt = 0; 
            
            
            char previousBit = '0';
            
    
            for (char currentBit : bit) {
                if (currentBit != previousBit) {
                    cnt++; 
                    previousBit = currentBit; 
                }
            }
            
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}
