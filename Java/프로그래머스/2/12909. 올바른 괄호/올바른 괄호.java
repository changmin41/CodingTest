import java.util.Stack;

class Solution {
    boolean solution(String s) {
        // 스택 선언
        Stack<Character> stack = new Stack<>();
        
        // 문자열의 각 문자를 순회
        for (char c : s.toCharArray()) {
            // 스택이 비어있다면 현재 문자를 추가
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            // 스택의 제일 윗 값이 '('이고 현재 문자가 ')'일 때 스택에서 제거
            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        // 스택이 비어있으면 true, 값이 하나 이상 존재하면 false 반환
        return stack.isEmpty();
    }
}