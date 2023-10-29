package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * 문제에 오류가 있음 bridge_length 는 올라갈 수 있는 트럭의 갯수이기도 하지만 트럭한대가 지나갈때 걸리는 시간이기도 함
 * <p>
 * 1. 대기 트럭 waitQueue, 다리를 건너는 트럭 progressQueue, 다리를 건너는 트럭의 시간 timeQueue 를 만듬.
 * 2. 전체경과시간(minute), 현재 다리 중량(bridgeWeight), 현재 다리를 건너는 트럭수(bridgeTruckCount), 다리를 지난 트럭수(completeCount)를 0으로 초기화
 * 3. 다리를 지난 트럭수가 처음 대기하고 있는 트럭 수와 같을 때 까지 loop
 * 4. 경과시간 + 1
 *
 * 5. 다리를 건너는 트럭의 시간 Queue 의 값이 bridge_length와 일치하면
 * 6. timeQueue에서 해당 시간을 poll
 * 7. 전체 다리 중량에서 해당 트럭의 중량을 뺌
 * 8. 다리를 건너고있는 트럭의 갯수에서 -1
 * 9. 완료한 트럭수 +1
 *
 * 10. waitQueue가 아직 비어있지 않으면
 * 11. waitQueue의 peek한 트럭의 무게와 전체 다리중량의 무게와 합했을때 weight와의 무게 계산, 다리를 건너고있는 트럭의 갯수와 계산하여 참이면
 * 12. progressQueue에 waitQueue를 poll해서 넣음.
 * 13. 전체 다리중량에 값을 더함
 * 14. 다리를 건너고있는 트럭의 갯수 +1
 * 15. timeQueue에 0을 넣음
 *
 * 16. timeQueue를 돌면서 값을 1씩 증가시킴
 */
public class Q42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitQueue = new LinkedList<>();
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> timeQueue = new LinkedList<>();

        for (int truckWeight : truck_weights) {
            waitQueue.add(truckWeight);
        }

        int minute = 0;
        int bridgeWeight = 0;
        int bridgeTruckCount = 0;
        int completeCount = 0;

        while (completeCount != truck_weights.length) {
            minute++;

            if (timeQueue.peek() != null && timeQueue.peek() == bridge_length) {
                timeQueue.poll();
                bridgeWeight -= progressQueue.poll();
                bridgeTruckCount -= 1;
                completeCount++;
            }

            if (waitQueue.peek() != null) {
                int truck = waitQueue.peek();
                if (truck + bridgeWeight <= weight && bridgeTruckCount <= bridge_length) {
                    bridgeWeight += truck;
                    bridgeTruckCount++;
                    progressQueue.add(waitQueue.poll());
                    timeQueue.add(0);
                }
            }

            for (int i = 0; i < timeQueue.size(); i++) {
                timeQueue.add(timeQueue.poll() + 1);
            }
        }

        return minute;
    }
}
