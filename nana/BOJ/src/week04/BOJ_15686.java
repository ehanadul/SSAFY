package week04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static int N, M;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE; // 최소 치킨 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        // 도시의 정보 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 집
                    house.add(new int[]{i, j});
                } else if (map[i][j] == 2) { // 치킨집
                    chicken.add(new int[]{i, j});
                }
            }
        }
        
        visited = new boolean[chicken.size()];
        selectChicken(0, 0); 
        System.out.println(result); //최소치킨 거리
    }

    //치킨집 선택 - 백트래킹
    static void selectChicken(int depth, int start) {
        if (depth == M) { // M개를 선택한 경우
            int sum = 0;
            for (int[] h : house) { // 모든 집
                int min = Integer.MAX_VALUE; // 최소 거리 초기화
                for (int[] s : selected) { // 선택한 치킨집과의 거리 계산
                    int d = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    min = Math.min(d, min); // 최소 거리 업데이트
                }
                sum += min; //최소 거리 합산
            }
            result = Math.min(result, sum); //최소 치킨 거리 업데이트
            return;
        }

        for (int i = start; i < chicken.size(); i++) { //모든 치킨집 탐색
            if (!visited[i]) {
                visited[i] = true; // 현재 치킨집 선택
                selected.add(chicken.get(i)); // 선택한 치킨집 추가
                selectChicken(depth + 1, i + 1); // 다음 치킨집 선택
                selected.remove(selected.size() - 1); // 선택한 치킨집 제거
                visited[i] = false; // 현재 치킨집 선택 해제
            }
        }
    }
}
