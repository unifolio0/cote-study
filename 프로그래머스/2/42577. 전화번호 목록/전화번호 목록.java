import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for (String ph : phone_book) {
            map.put(ph, 1);
        }
        for (String s : map.keySet()) {
            for (int i = 1; i < s.length(); i++) {
                if (map.containsKey(s.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}