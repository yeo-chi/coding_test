package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 *
 * Stack에 값을 넣는다. 꺼냈을때 값이 똑같으면 answer에 추가하지 않고 다르면 추가한다.
 */
public class Q12096 {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if(stack.empty()) {
                answer.add(i);
            } else {
                Integer a = stack.peek();
                if (a != i) {
                    answer.add(i);
                }
            }
            stack.add(i);
        }

        return answer.stream().mapToInt(n -> n).toArray();
    }
}
