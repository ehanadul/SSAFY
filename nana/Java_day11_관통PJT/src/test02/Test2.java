package test02;

import java.util.Arrays;

import com.google.gson.Gson;

public class Test2 {
	public static void main(String[] args) {
		String str = "[{\"name\":\"luna\",\"age\":3},{\"name\":\"max\",\"age\":3},{\"name\":\"daisy\",\"age\":3}]";
		
		
		
		//JSON 문자열 -> 객체 배열

		Gson gson new Gson();
		Person[] arr = gson.fromJson(str, Person[].class);
		System.out.println(Arrays.toString(arr));
		
		
		
	}
}
