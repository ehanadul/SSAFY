package day0809_문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6190 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); 
            
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken()); 
            }
            
            int max = -1; 
            
           
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int product = num[i] * num[j]; 
                    if (increasing(product)) { 
                        max = Math.max(max, product); 
                    }
                }
            }
            
       
            System.out.printf("#%d %d\n", tc, max);
        }
        
        br.close();
    }
    public static boolean increasing(int num) {
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length() - 1; i++) {
            if (strNum.charAt(i) > strNum.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
