package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 *
 * 떨어지지 않는 갯수를 세는 것이 아님.
 * 1초->2초 시점으로 갈때 떨어지더라도 1초간 금액은 유지한거.
 * [2, 1] -> [1, 0]
 *
 * 1. priceQueue에 값을 넣음. answer의 크기는 prices 의 크기와 같음
 * 2. 첫번째 값을 빼내고 나머지 priceQueue로 forLoop를 돌리면서 값 비교
 * 3. answer 를 계속 누적하다 작은 값이 나오면 그대로 멈추고 answer의 다음 배열로 이동
 */
public class Q42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> priceQueue = new LinkedList<>();

        for (int price : prices) {
            priceQueue.add(price);
        }

        int number = 0;
        while (priceQueue.peek() != null) {
            int value = priceQueue.poll();

            answer[number] = 0;

            for (Integer integer : priceQueue) {
                answer[number]++;
                if (value > integer) {
                    break;
                }
            }

            number++;
        }

        return answer;
    }
}
