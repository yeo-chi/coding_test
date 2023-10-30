package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
public class Q42884 {
    public int solution(int[][] routes) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(routes, (o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < routes.length - 1; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                int x = 0;
                int y = 0;

                //x가 범위안에 포함되어있냐
                if (routes[j][0] <= routes[i][0] && routes[j][1] >= routes[i][0]) {
                    x = routes[i][0];
                    //y가 범위안에 포함되어있냐
                    if (routes[j][0] <= routes[i][1] && routes[j][1] >= routes[i][1]) {
                        y = routes[i][1];
                    } else {
                        y = routes[j][1];
                    }
                    System.out.println(true);
                } else if (routes[j][0] <= routes[i][1] && routes[j][1] >= routes[i][1]) {
                    //x가 범위안에 포함되어있지 않다면 y가 포함되어있냐
                    y = routes[i][1];
                    x = Math.max(routes[i][0], routes[j][0]);
                    System.out.println(true);
                } else {
                    // 둘다 포함되어있지 않다면
                    System.out.println(false);
                }
            }
        }

        return 0;
    }
}
