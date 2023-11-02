package programmers;

import java.util.Stack;

public class Q12311 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x == ')')  {
                while(stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }
}
