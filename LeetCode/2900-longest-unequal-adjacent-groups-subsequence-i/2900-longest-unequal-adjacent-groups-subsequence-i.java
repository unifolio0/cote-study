import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        int idx = 0;
        for (int i = 1; i < words.length; i++) {
            if (groups[idx] != groups[i]) {
                idx = i;
                result.add(words[i]);
            }
        }
        return result;
    }
}
