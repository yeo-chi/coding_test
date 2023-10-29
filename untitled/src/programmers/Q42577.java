package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * <p>
 * 숫자로된 문자열을 오름차순으로 정렬하고 바로 다음문자와 시작이 같은지 확인한다.
 */
public class Q42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String s = phone_book[i];
            if (phone_book[i + 1].startsWith(s)) {
                return false;
            }
        }
        return true;
    }
}
