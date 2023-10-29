package programmers;

import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * 
 * 가장 많은 수의 폰켓몬을 가져가야함 -> Set을 이용한 중복제거
 * 최대 마리수는 전체 배열의 반절, 최대 마리수와 Set의 길이를 계산해서 둘중 최소값을 리턴함
 */
public class Q1845 {
    public int solution(int[] nums) {
        HashSet<Integer> hashMap = new HashSet<>();
        for (int num : nums) {
            hashMap.add(num);
        }

        return Math.min(hashMap.size(), nums.length / 2);
    }
}
