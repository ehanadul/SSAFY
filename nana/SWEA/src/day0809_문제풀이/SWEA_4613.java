package day0809_문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
        
        for (int tc = 1; tc <= T; tc++) {
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]); // 행
            int M = Integer.parseInt(nm[1]); // 열

            char[][] flag = new char[N][M];
            for (int i = 0; i < N; i++) {
                flag[i] = br.readLine().toCharArray(); // 깃발 색상 입력
            }
            
            int minCnt = Integer.MAX_VALUE; // 최소 색칠 횟수 초기화
            
            // 모든 가능한 i (W 영역 끝)와 j (B 영역 끝)를 탐색
            for (int i = 0; i < N - 2; i++) { 
                for (int j = i + 1; j < N - 1; j++) { 
                    int cnt = 0;
                    
                    // W 영역 (0 to i)
                    for (int row = 0; row <= i; row++) {
                        for (int col = 0; col < M; col++) {
                            if (flag[row][col] != 'W') {
                                cnt++;
                            }
                        }
                    }

                    // B 영역 (i+1 to j)
                    for (int row = i + 1; row <= j; row++) {
                        for (int col = 0; col < M; col++) {
                            if (flag[row][col] != 'B') {
                                cnt++;
                            }
                        }
                    }
                    
                    // R 영역 (j+1 to N-1)
                    for (int row = j + 1; row < N; row++) {
                        for (int col = 0; col < M; col++) {
                            if (flag[row][col] != 'R') {
                                cnt++;
                            }
                        }
                    }
                    
                    // 최소 변경 횟수 업데이트
                    minCnt = Math.min(minCnt, cnt);
                }
            }
            // 결과 출력
            System.out.printf("#%d %d\n", tc, minCnt);
        }
    }
}
