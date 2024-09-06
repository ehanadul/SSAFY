package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
    // 5215. 햄버거 다이어트

    static int T, N, L;
    static int[] point;
    static int[] cal;
    static boolean[] selected; 
    static int maxPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            
            point = new int[N];
            cal = new int[N];
            selected = new boolean[N]; 
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                point[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            
            maxPoint = 0;
            burger(0, 0, 0); 
            System.out.printf("#%d %d\n", tc, maxPoint);
        }
        br.close();
    }

    // 백트래킹
    public static void burger(int idx, int currentScore, int currentCal) {
        if (idx == N) {
            if (currentCal <= L) { 
                maxPoint = Math.max(maxPoint, currentScore); 
            }
            return;
        }

        selected[idx] = false;
        burger(idx + 1, currentScore, currentCal);

        selected[idx] = true;
        burger(idx + 1, currentScore + point[idx], currentCal + cal[idx]);
    }
}
