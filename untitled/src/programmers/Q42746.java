package programmers;

import java.util.*;

/**
 *
 */
public class Q42746 {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2));
        StringBuilder ans = new StringBuilder();

        for (int num : numbers) {
            pq.offer(String.valueOf(num));
        }

        while (!pq.isEmpty()) {
            ans.append(pq.poll());
        }

        if (ans.charAt(0) == '0')
            return "0";
        else return ans.toString();
    }
}
