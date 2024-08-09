package day0806_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1222 {
    public static String change(String str) { //변환
        Map<Character, Integer> isp = new HashMap<>();
        Map<Character, Integer> icp = new HashMap<>();
        isp.put('+', 1); 
        icp.put('+', 1);

        Stack<Character> stack = new Stack<>();
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (icp.containsKey(ch)) { //연산자 확인
                if (stack.isEmpty()) {
                    stack.push(ch); 
                } else {
                    while (!stack.isEmpty() && (isp.get(stack.peek()) >= icp.get(ch))) {
                        st.append(stack.pop()); //StringBuilder에 추가
                    }
                    stack.push(ch);
                }
            } else { 
                st.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            st.append(stack.pop());
        }
        return st.toString(); //StringBuilder문자열 변환
    }
    
    //계산
    public static int calculator(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '+') { //연산자
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            } else { //피연산자
                stack.push(Character.getNumericValue(curr));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int t = 1; t <= 10; t++) {
                br.readLine(); 
                String tc = br.readLine(); 
                System.out.printf("#%d %d\n", t, calculator(change(tc)));
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
