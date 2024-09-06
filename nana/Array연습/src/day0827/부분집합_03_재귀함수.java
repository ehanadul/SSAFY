package day0827;

import java.util.Arrays;

public class 부분집합_03_재귀함수 {
	// static 
	static String[] 재료 = {"단무지", "햄", "오이", "시금치"};
	static int N = 4;// 재료의 수
	static boolean[] sel; // 해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열
	
	public static void main(String[] args) {
		N=4;
		sel= new boolean[N];
		powerset(0);
	}
	//N은 이미 static 하니까 들고 다닐 필요는 없다.
	//idx : 내기 어떤 재료를 선택할 지에 대한 인겟스
	public static void powerset(int idx) {
		//기저조건 : base case -> 재귀를 빠져나가는 조건
		if(idx == N) {
			String tmp = "김밥 : ";
			for(int i =0; i<N;i++) {
				if(sel[i])
					tmp += 재료[i];
			}
			System.out.println(tmp);
			return;
		}
		
		
		//재귀부분 : 나 자신을 다시 호춣하는 부분	
		sel[idx] = true; //해당 위치의 재료를 사용했어요~
		powerset(idx +1);
		
		sel[idx] =	false;//해당 위치의 재료를 사용하지 않았어요
		powerset(idx+1);
	}
}
