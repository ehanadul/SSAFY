package day0903;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_2383_2 {
    // 사람의 위치, 계단의 위치(2개)
    // 1. 모든 사람이 계단을 선택(부분집합) - 자신이 선택한 계단 기억
    // 2. 각각의 경우에 대해 시뮬레이션을 진행
    //    - 계단까지 이동 - 사람의 초기 위치 - 계단까지 위치 => 기억.
    //    - 계단을 내려가기 시작(계단 인원 제한) => 큐
    //         => 큐에 있는 사람만 내려갈 수 있기 때문에  
    //         => 큐에 들어가는 시점이 중요 - 기억.     
    //               도착은 했지만 큐에 들어간 사람, 도착은 했는데 큐에 못들어간 사람.
    //    - 계단을 내려가기 완료(모든 사람에 대해 완료되어야 끝).
    // => 클래스를 설계하는 것이 좋다.
     
    static class Stair {
    	int r, c, k; // 계단의 위치(row,col), 길이
    	
    	public Stair(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
    }
    
    static class Person{
    	int r, c; // 사람 좌표 <= 입력 받을 때
    	int stair; // 자신이 선택한 계단 번호 (배열의 idx) <= 부분집합 재귀함수를 돌릴 때
    	int arriveTime; // 계단까지의 거리(도착 시간)
    	int stairTime; //큐에 들어가는 시점(계단을 내려가기 시작한 시점)
    	
    	public Person(int r, int c) {
    		this.r = r;
    		this.c = c;
		}
		
    	void calArriveTime(){
            this.arriveTime = Math.abs(this.r - stairs[stair].r)+ Math.abs(this.c - stairs[stair].c);
        }
    }
    
    static Stair[] stairs; //계단은 항상 2개이므로 길이가 2인 배열이다. 인덱스 0, 1
    static Queue<Person>[] qs;  // 각 계단에 대기 중인 사람들을 관리하기 위한 큐
    							//qs[0]: 첫 번째 계단에 대기 중인 사람들의 큐
    							//qs[1]: 두 번째 계단에 대기 중인 사람들의 큐
    
    static ArrayList<Person> persons; // 모든 사람의 리스트
    static boolean[] visited; // 사람이 큐에 들어갔는지 여부= 사람이 계단에 대기 중인지
    
    static int N, min; // 배열의 크기, 최소값
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int T = sc.nextInt();
    	
    	for(int tc = 1; tc<=T; tc++) {
    		N = sc.nextInt();
    		
    		persons = new ArrayList<>(); // 사람의 리스트 초기화
    		qs = new LinkedList[2]; // 계단의 큐
    		qs[0] = new LinkedList<>();
    		qs[1] = new LinkedList<>();
    		
    		stairs = new Stair[2];//계단의 배열
    		
    		min = Integer.MAX_VALUE;
    		
    		int stairIdx =0;
    		for(int r=1; r<=N; r++) {
    			for(int c=1; c<=N; c++) {
    				int num = sc.nextInt();
    				
    				if (num == 0) {// 빈 곳 패스
    					continue;
    				}else if(num == 1) {// 사람 발견
    					persons.add(new Person(r, c)); 
    				}else {
    					stairs[stairIdx++] = new Stair(r,c,num);
    				}
    			}
    		}
    		
    		// 부분집랍 돌리기
    		// 부분집합의 각가의 케이스에 대해 시간 계산 -> 최소값 갱신
    		go(0);
    		
    		System.out.println("#"+tc+" "+min);
    	}
	}
    
    
    private static void go(int idx) {
    	//기저조건
    	if(idx == persons.size()) {
    		
    		// 부분집합이 하나씩 만들어짐
    		// 시뮬레이션 돌리고
    		// 최소값 갱신
    		int time = simulation();
    		if(min > time) min = time;
    		
    		return;
    	}
    	
    	
    	// 유도조건
    	persons.get(idx).stair = 0;
    	persons.get(idx).calArriveTime();
    	go(idx+1);
    	
    	persons.get(idx).stair = 1;
    	persons.get(idx).calArriveTime();
    	go(idx+1);
    	
    }


	private static int simulation() {
		// 부분집합의 하나의 케이스에 대해 시간 계산
		// 큐에 올라가는 시점
		visited = new boolean[persons.size()];
		
		int cnt = 0;// 계단에 도착해서 큐에 진입한 사람 수
		int time = 1;
		
		while(true) {
			//큐 -> 검사 ( 다 내려간 사람들은 제거)
			
			
		}
				
		return 0;
	}
    
    
}