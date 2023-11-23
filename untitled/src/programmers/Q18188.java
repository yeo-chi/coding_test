package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 * <p>
 * 그리디로 Y값 정렬 후. 다음 좌표의 X값이 앞의 Y값에 포함되는지 확인
 * 포함이되면 카운트 X, 포함이 안되면 카운트를 올리고 비교한 Y 좌표를 기준좌표로 잡음
 */
public class Q18188 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (Comparator.comparingInt(o -> o[1])));

        int temp = 0;
        for (int[] target : targets) {
            if (temp <= target[0]) {
                temp = target[1];
                answer++;
            }
        }
        return answer;
    }
}
