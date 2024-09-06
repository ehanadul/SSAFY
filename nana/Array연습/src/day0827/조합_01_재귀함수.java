package day0827;

import java.util.Arrays;

public class 조합_01_재귀함수 {
	// static 
	static String[] 재료 = {"상추", "패티", "치즈"};
	static int N, R;// N : 재료의 수. R : 내가 뽑고 싶은 ㅂ재료의 스
	static String[] sel; // 해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열
	
	public static void main(String[] args) {
		N =4;
		R=2;
		sel = new String[R];
		
		combination(0,0);
		
	}
	
	public static void combination(int idx, int sidx) {
		//기저조건
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
			}
		if(idx ==N) {
			return;
		}
		
		
		
		//재귀부분
		//해당 idx 번째 재료를 사용했는지 안했는지
		sel[sidx] = 재료[idx];
		combination(idx +1,sidx + 1);
		combination(idx + 1, sidx);//햄버거의 길제 재료를 아직 뽑지 않았다
		
	}
}
