import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack2_계산기 {
    public static void main(String[] args) {
        String expression = "(6+5*(2-8)/2)";
        
        int result = evaluate(expression);
        System.out.println("결과: " + result);
    }

    // 중위 표기식을 계산해주는 함수
    static int evaluate(String expression) {
        String postfix = infixToPostfix(expression);
        return evaLPostfix(postfix);
    }

    static Map<Character, Integer> map = new HashMap<>();
    
    static {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
    }

    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            if ('0' <= c && c <= '9') {
                // 피연산자가 나오면 바로 출력
                postfix.append(c);
            } else if (c == '(') {
                // 여는 괄호는 스택에 push
                stack.push(c);
            } else if (c == ')') {
                // 닫는 괄호는 여는 괄호가 나올 때까지 pop
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // 여는 괄호 제거
            } else {
                // 연산자
                while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        // 스택 비워주기
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    static int evaLPostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if ('0' <= c && c <= '9') {
                stack.push(c - '0');
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                
                if (c == '+') {
                    result = num1 + num2;
                } else if (c == '-') {
                    result = num1 - num2;
                } else if (c == '*') {
                    result = num1 * num2;
                } else if (c == '/') {
                    result = num1 / num2;
                }
                
                stack.push(result);
            }
        }
        
        return stack.pop(); 
    }
}
