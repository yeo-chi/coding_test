package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * <p>
 * 이름 순으로 정렬하여 두 배열을 비교, 값이 틀린 위치의 사람이 빠짐.
 */
public class Q42576 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[completion.length];
    }
}
