package day0808_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_1974_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc =1; tc<=T;tc++) {
            int[][] sudoku = new int[9][9];
            for(int i = 0; i <9;i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for(int j = 0;j <9;j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean isValid = true;
            Set<Integer>[] row = new HashSet[9]; 
            Set<Integer>[] col = new HashSet[9];
            Set<Integer>[] box = new HashSet[9];
             
            for(int i =0; i <9;i++) {
                row[i] = new HashSet<>();
                col[i] = new HashSet<>();
                box[i] = new HashSet<>();
            }
             
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int num = sudoku[i][j];
                    if (row[i].contains(num) || 
                        col[j].contains(num) || 
                        box[(i/3)*3 + j/3].contains(num)) {
                        isValid = false;
                        break ;
                    }
                     
                    row[i].add(num);
                    col[j].add(num);
                    box[(i/3)*3 + j/3].add(num);
                }
                if (!isValid) break; 
            }
            System.out.printf("#%d %d\n", tc, (isValid ? 1 : 0));
        }
    }
}