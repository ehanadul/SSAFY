

public class Stack2_팩토리얼 {
	public static void main(String[] args) {
		System.out.println(factorial(10));
		System.out.println(factorial2(result));
	}
	
	
	
	
	//1부터 n까지의 곱을  return
	static int factorial(int N) {
		int result =1;
		for(int i =1; i<=N;i++) {
			result *= i;
		}
		return result;
	}
	
	static int factorial2(int N) {
		if(N==0 || N ==1) {
			return 1;
		return N* factorial (N-1);
		}
		
	}
}
