package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Q42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        //한개만 가져온 학생 수
        int fit = n - lost.length - reserve.length;
        List<Integer> losts = new ArrayList<>();
        for (int i : lost) {
            losts.add(i);
        }
        int add = 0;

        for (int i : reserve) {
            if (losts.removeIf(number -> number == i - 1)) {
                add++;
            }
        }

        return add + fit +reserve.length;
    }
}
