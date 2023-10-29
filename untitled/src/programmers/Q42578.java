package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * <p>
 * Map에 각 옷의 종류를 Key로 넣으면서 옷을 입지않을 경우가 있으므로 1로 value를 초기화
 * 각 경우의 수를 모두 곱하고 모두 안입는 하나의 경우의수 1을 뺌
 */
public class Q42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] sArr : clothes) {
            hashMap.put(sArr[1], 1);
        }

        for (String[] sArr : clothes) {
            hashMap.put(sArr[1], hashMap.get(sArr[1]) + 1);
        }

        int answer = 1;
        for (int ea : hashMap.values()) {
            answer *= ea;
        }

        return answer - 1;
    }
}
