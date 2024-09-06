package day0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_2 {
//2112. [모의 SW 역량테스트] 보호 필름
	
    static int D, W, K; // 행, 열, 통과조건
    static int FinalChem; // 마지막 약품처리 갯수
    static int[][] films; // 보호필름
	     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            films = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    films[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // <==============입력 받기 끝===============>
            FinalChem = Integer.MAX_VALUE; // 마지막 약품처리 갯수는 테스트 케이스마다 초기화 시켜줘야함
            if(K == 1) FinalChem = 0; // K가 1이라면 약품처리 필요 없음
            else dfs(0, 0);
            sb.append("#").append(tc).append(" ").append(FinalChem).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int depth, int chemical) {
        // 마지막 약품처리 갯수가 현재 약품처리 갯수보다 작거나 같아면 더이상 진행할 필요 없음
        if(FinalChem <= chemical) return; 
        if(depth == D) { // depth == D일 때, 성능테스트 진행
            if(performTest()) { // 성능테스트 통과 시 최솟값 저장
                FinalChem = Math.min(FinalChem, chemical);
            }
            return; // 해당 depth 종료
        }
        int[] origRow = films[depth].clone(); // 바꿀 행의 원래 값 저장
        dfs(depth + 1, chemical); // 해당 행에서 약품 처리 안할 때
        Arrays.fill(films[depth], 0); // 해당 행에서 약품 처리 A로 할 때
        dfs(depth + 1, chemical + 1); // 다음 행으로 넘어가고, 약품 처리 했으므로, 약품 처리 값 +1 
        Arrays.fill(films[depth], 1); // 해당 행에서 약품 처리 B로 할 때
        dfs(depth + 1, chemical + 1); // 다음 행으로 넘어가고, 약품 처리 했으므로, 약품 처리 값 +1
        films[depth] = origRow; // 해당 depth의 보호 필름 원래 상태로 복원
    }
    // 약품 처리할 열을 조합으로 구하는 메서드
    static boolean performTest() {
        for (int iW = 0; iW < W; iW++) {
            boolean isPass = false;
            int kCnt = 1; // 처음 선택한 property 을 카운트한다고 생각하고 kCnt을 1로 초기화
            int property = films[0][iW];
            for (int iD = 1; iD < D; iD++) { // 처음 선택한 property 을 제외하기 위해 iD는 1부터 시작 
                if(property == films[iD][iW]) kCnt++; // 다음 property 와 같다면 카운트
                else {
                    kCnt = 1; // 아니면 다시 초기화
                    property = films[iD][iW]; // property 을 현재 특성으로 초기화
                }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
                if(kCnt == K) { // K 기준을 만족했다면
                    isPass = true; // 해당 열은 통과
                    break;
                }
            }
            if(!isPass) return false; // 만약 해당 열이 불통이면 현재 필름은 성능검사 불통
        }
        return true; // 전체 열이 통과이면 통과
    }   
}

