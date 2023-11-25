package programmers;

import java.util.ArrayList;
import java.util.List;

public class CCC {

    public int solution(int[] arr, int minSelectCount, int maxPrice) {
        int length = arr.length;
        boolean[] visited = new boolean[arr.length];

        List<Integer> answer = new ArrayList<>();

        for (int i = minSelectCount; i <= length; i++) {
            answer.addAll(combination(arr, visited, 0, length, i, new ArrayList<>()));
        }

        return (int) answer.stream().filter(x -> x <= maxPrice).count();
    }

    static List<Integer> combination(int[] arr, boolean[] visited, int start, int n, int r, List<Integer> answer) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            answer.add(sum);
            return answer;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, answer);
            visited[i] = false;
        }
        return answer;
    }
}
