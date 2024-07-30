import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] s : clothes) {
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }
        int res = 1;
        for (Integer k : map.values()) {
            res *= (k + 1);
        }
        return res - 1;
    }
}
