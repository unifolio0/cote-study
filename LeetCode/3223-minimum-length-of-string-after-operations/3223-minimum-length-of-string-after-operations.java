import java.util.*;

class Solution {
    public int minimumLength(String s) {
        int[] alp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alp[s.charAt(i) - 'a']++;
        }
        int count = s.length();
        for (int num : alp) {
            if (num == 0) continue;
            count -= num % 2 == 0 ? num - 2 : num - 1;
        }
        return count;
    }
}
