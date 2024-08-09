package test02;

import java.util.Arrays;

import com.google.gson.Gson;

public class Teat1 {
	public static void main(String[] args) {
		
		Person[] arr = new Person[3];
		arr[0]= new Person("luna",3);
		arr[1]= new Person("max",3);
		arr[2]= new Person("daisy",3);
	
		System.out.println(Arrays.toString(arr));
		
		
		//객체 배열 => JSON으로 만들기
		
		Gson gson = new Gson();
		String arrStr = gson.toJson(arr);
		System.out.println(arrStr);
	}
}
