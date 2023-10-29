package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * <p>
 * 완벽한 괄호가 만들어져야 하기 때문에 첫번째가 )가 오거나 마지막이 (가 오면 안됨
 * 
 * 중간에라도 닫힌괄호가 더 많아져서는 안됨. 
 */
public class Q12909 {
    public boolean solution(String s) {
        int count = 0;

        //첫번째나 마지막 괄호체크
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            //닫힌괄호가 더 많아졌는지 체크
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
