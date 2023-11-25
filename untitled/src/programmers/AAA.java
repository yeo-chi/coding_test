package programmers;

import java.util.*;

public class AAA {
    public String[] solution(String[] orders) {
        HashMap<String, Set<String>> fdsa = new HashMap<>();

        for (String order : orders) {
            String[] asdf = order.split(" ");

            Set<String> fdsaSet = fdsa.get(asdf[0]);

            if (fdsaSet == null) {
                fdsaSet = new HashSet<>();
            }

            for (int j = 1; j < asdf.length; j++) {
                fdsaSet.add(asdf[j]);
            }

            fdsa.put(asdf[0], fdsaSet);
        }

        int max = 0;
        for (String s : fdsa.keySet()) {
            int length =fdsa.get(s).size();
            if (length > max) {
                max = length;
            }
        }

        List<String> answerList = new ArrayList<>();

        for (String s : fdsa.keySet()) {
            if (fdsa.get(s).size() == max) {
                answerList.add(s);
            }
        }

        String[] answer = answerList.toArray(new String[answerList.size()]);

        Arrays.sort(answer);

        return answer;
    }
}
