package programmers;

import java.util.ArrayList;
import java.util.List;

public class ASD {
    public static long getMaxBeauty(List<Integer> arr, int k) {
        // Write your code here
        List<Integer> sumArr = new ArrayList<>();

        for(int i = 0; i < arr.size() - k + 1; i++) {
            int temp = 0;
            for(int j = i; j < i + k; j++) {
                temp += arr.get(j);
            }
            sumArr.add(temp);
        }

        return sumArr.stream().mapToLong(n -> n).max().getAsLong();
    }
}
