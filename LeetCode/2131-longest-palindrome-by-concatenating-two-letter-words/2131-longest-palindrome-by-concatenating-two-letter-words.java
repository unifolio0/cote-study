import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> pelMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == words[i].charAt(1)) {
                pelMap.put(words[i], pelMap.getOrDefault(words[i], 0) + 1);
                continue;
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int count = 0;
        boolean first = true;
        for (String key : pelMap.keySet()) {
            if (pelMap.get(key) % 2 == 1)  {
                if (first) {
                    count += pelMap.get(key) * 2;
                    first = false;
                } else {
                    count += (pelMap.get(key) - 1) * 2;
                }
                continue;
            }
            count += pelMap.get(key) * 2;
        }
        for (String key : map.keySet()) {
            String rev = key.charAt(1) + "" + key.charAt(0);
            if (map.containsKey(rev)) {
                count += Math.min(map.get(key), map.get(rev)) * 2;
            }
        }
        return count;
    }
}
