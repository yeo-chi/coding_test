package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * <p>
 * Queue 2개에 각 값을 넣고 반복으로 진행률을 더함
 * <p>
 * Queue의 맨앞의 값이 100이상일때 뒤에까지 값이 100이상인 데이터를 다 뽑으면서 count를 진행
 * <p>
 * 이렇게 계속 반복
 */
public class Q42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressQueue = new LinkedList<>();

        for (int progress : progresses) {
            progressQueue.add(progress);
        }

        Queue<Integer> speedsQueue = new LinkedList<>();

        for (int speed : speeds) {
            speedsQueue.add(speed);
        }

        List<Integer> counts = new ArrayList<>();

        while (progressQueue.peek() != null && speedsQueue.peek() != null) {

            for (int i = 0; i < progressQueue.size(); i++) {
                progressQueue.add(progressQueue.peek() + speedsQueue.peek());
                speedsQueue.add(speedsQueue.peek());
                progressQueue.poll();
                speedsQueue.poll();
            }

            int count = 0;

            while(progressQueue.peek() >= 100) {
                progressQueue.poll();
                speedsQueue.poll();
                count++;

                if(progressQueue.peek() == null) {
                    break;
                }
            }

            if(count != 0) {
                counts.add(count);
            }
        }

        return counts.stream().mapToInt(n -> n).toArray();
    }
}
