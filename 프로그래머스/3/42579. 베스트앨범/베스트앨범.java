import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerTemp = new ArrayList<>();
        //장르, 총 재생된 횟수
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }
        // 속한 노래가 많이 재생된 장르 순서
        List<Integer> list = new ArrayList<>();
        map.values().stream().sorted(Comparator.reverseOrder()).forEach(list::add);

        List<String> rank = new ArrayList<>(); //genre
        for (int i = 0; i < list.size(); i++) {
            for (String key : map.keySet()) {
                if (map.get(key).equals(list.get(i))) {
                    rank.add(key);
                }
            }
        }

        List<String> genre = Arrays.asList(genres);
        for (String r : rank) {
            List<Integer> index = new ArrayList<>();
            for (String g : genre) {
                if (g.equals(r)) {
                    index.add(genre.indexOf(g));
                    genres[genre.indexOf(g)] = "";
                }
            }
            List<Integer> sort = new ArrayList<>();
            for (Integer i : index) {
                sort.add(plays[i]);
            }
            sort.sort(Comparator.reverseOrder());
            if (sort.size() >= 2) {
                answerTemp.add(sort.get(0));
                answerTemp.add(sort.get(1));
            } else if (!sort.isEmpty()) {
                answerTemp.addAll(sort);
            }
        }

        List<Integer> index = new ArrayList<>();
        for (Integer ii : answerTemp) {
            for (int i = 0; i < plays.length; i++) {
                if (ii.equals(plays[i])) {
                    index.add(i);
                    plays[i] = -1;
                }
            }
        }

        answer = index.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}