import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<int[]>> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + plays[i]);
            if (genrePlayCount.containsKey(genre)) {
                List<int[]> ints = genrePlayCount.get(genre);
                ints.add(new int[]{plays[i], i});
            } else {
                List<int[]> arr = new ArrayList<>();
                arr.add(new int[]{plays[i], i});
                genrePlayCount.put(genre, arr);
            }
        }
        List<String> strings = genreCount.keySet().stream()
                .sorted((s1, s2) -> genreCount.get(s2) - genreCount.get(s1))
                .collect(Collectors.toList());
        List<Integer> ret = new ArrayList<>();
        for (String s : strings) {
            List<int[]> ints = genrePlayCount.get(s);
            List<int[]> list = ints.stream().sorted((i1, i2) -> i2[0] - i1[0])
                    .limit(2)
                    .collect(Collectors.toList());
            if (list.size() == 1) {
                ret.add(list.get(0)[1]);
            }
            if (list.size() == 2) {
                ret.add(list.get(0)[1]);
                ret.add(list.get(1)[1]);
            }
        }
        int[] r = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            r[i] = ret.get(i);
        }
        return r;
    }
}
