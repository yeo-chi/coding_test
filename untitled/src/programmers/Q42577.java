package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * <p>
 * for문을 돌리면서 해당 값의 길이만큼으로 봤을떄 일치하는 값이 있는지 확인한다.
 */
public class Q42577 {
    public boolean solution(String[] phone_book) {
        for (String s : phone_book) {
            int sLength = s.length();
            int count = 0;

            for (String s1 : phone_book) {
                try {
                    if (s.equals(s1.substring(0, sLength))) {
                        count++;
                    }
                } catch (StringIndexOutOfBoundsException e) {

                }
            }

            if (count == 2) {
                return false;
            }
        }

        return true;
    }
}
