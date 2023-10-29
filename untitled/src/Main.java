import programmers.Q42578;
import programmers.Q42579;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Q42579 a = new Q42579();

        int[] aa = a.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});

        System.out.println(Arrays.toString(aa));
    }
}
