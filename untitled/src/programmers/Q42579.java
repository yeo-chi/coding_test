package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * <p>
 * Map<장르, Map<곡ID, 곡재생횟수>>로 구조를 잡음
 * <p>
 * 각 장르별 Map의 곡 재생횟수를 기준으로 오름차순으로 정렬
 * <p>
 * 각 장르별 Map의 총합으로 순위를 결정후 각 장르별 Map의 상위 2개씩의 ID값을 배열에 저장
 */
public class Q42579 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Map<Integer, Integer>> maps = new HashMap<>();

        for (String genre : genres) {
            maps.put(genre, new HashMap<>());
        }

        for (int i = 0; i < genres.length; i++) {
            maps.get(genres[i]).put(i, plays[i]);
        }


        //장르별 재생횟수 총합
        Map<String, Integer> maps2 = new HashMap<>();

        for (String s : maps.keySet()) {
            maps2.put(s, maps.get(s).values().stream().mapToInt(n -> n).sum());
        }

        List<String> maps2Keys = new ArrayList<>(maps2.keySet());

        //장르별 재생횟수의 총합을 내림차순으로 정렬
        maps2Keys.sort((o1, o2) -> (maps2.get(o2).compareTo(maps2.get(o1))));

        //정렬된 재생횟수의 총합에서 각 키당 아이디의 2순위까지 리스트에 넣음
        maps2Keys.forEach(s -> {
            Map<Integer, Integer> playPerId = maps.get(s);

            List<Integer> integers = new ArrayList<>(playPerId.keySet());

            integers.sort((o1, o2) -> (playPerId.get(o2).compareTo(playPerId.get(o1))));

            if (integers.size() == 1) {
                answer.add(integers.get(0));
            } else {
                answer.add(integers.get(0));
                answer.add(integers.get(1));
            }
        });

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
