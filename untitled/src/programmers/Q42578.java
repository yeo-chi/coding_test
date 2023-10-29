package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * <p>
 * HashSet을 사용하여 옷의 종류를 구하고, 각 옷의 종류의 갯수를 넣음
 * 옷을 입지 않을 경우가 있으므로 초기화 할때 0이 아닌 1로 초기화
 * 모든 경우의 수를 곱하여 값을 얻고, 옷을 한개라도 입어야하므로 모든 값이 none 인 경우의수 1을 빼 값을 계산한다.
 */
public class Q42578 {
    public int solution(String[][] clothes) {
        Set<String> hashSet = new HashSet<>();

        for (String[] sArr : clothes) {
            hashSet.add(sArr[1]);
        }

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashSet.forEach(s -> hashMap.put(s, 1));

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
