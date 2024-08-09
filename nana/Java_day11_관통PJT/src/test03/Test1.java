package test03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.google.gson.Gson;

public class Test1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br new BufferedReader(new InputStreamReader(new FileInputStream("refrigerator.json")));
		String str = null;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str); //한줄씩 이어 붙인다
		}
		//이 while문을 빠져나오면 sb에는 모든 문자열이 저장되어 있음
		Gson gson = new Gson(); 
		Refrigerator[] arr = gson.fromJson(sb.toString(), Refrigerator[].class);
		
		System.out.println(Arrays.toString(arr));
		arr[0].setCategory("김치냉장고");
		
		Buffe
	}
}
