package programmers;

import java.util.ArrayList;
import java.util.List;

public class BBB {
    int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int[] solution(int day, int k) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < months.length -1; i++) {
            int a = sumHoliday(i, day, k);

            int result = isHoliday(a);

            answerList.add(result);
        }

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int isHoliday(int day) {
        int mod = day % 7;

        return (mod == 0 || mod == 6) ? 1 : 0;
    }

    public int sumHoliday(int month, int day, int k) {
        int sum = 0;
        for (int i = 0; i <= month; i++) {
            sum += months[i];
        }
        return sum + k + day;
    }
}
