package programmers;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * <p>
 * priorities 를 Queue에 넣음 proQueue(1, 1, 9, 1, 1, 1)
 * priorites 의 순서를 다른 Queue에 넣음 orderQueue(0, 1, 2, 3, 4, 5)
 * while로 proQueue가 null일 때 까지 loop
 * proQueue의 첫번째 값을 가져옴
 * 나머지 proQueue를 stream으로 변환해서 filter를 통해 더 큰 값이 있는지 확인 (orderQueue도 poll) 5-1. 없다면 order 라는 List에 add. 5-2. 있다면 각각 value와 orderValue를 다시 각 Queue에 add
 * order에 indexOf로 location이 있는 위치의 index를 가져옴
 * 순서이기 때문에 +1
 */
public class Q42587 {
    public int solution(int[] priorities, int location) {
        Queue<Integer> proQueue = new LinkedList<>();
        Queue<Integer> orderQueue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            proQueue.add(priorities[i]);
            orderQueue.add(i);
        }

        while (proQueue.peek() != null) {
            int value = proQueue.poll();
            int orderValue = orderQueue.poll();

            if (proQueue.stream().filter(num -> value < num).toList().size() == 0) {
                order.add(orderValue);
            } else {
                proQueue.add(value);
                orderQueue.add(orderValue);
            }
        }

        return order.indexOf(location) + 1;
    }
}
