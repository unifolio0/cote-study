import java.util.*;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] presum = new int[words.length + 1];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        presum[0] = 0;
        int pre = 0;
        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                pre++;
                presum[i + 1] = pre;
            } else {
                presum[i + 1] = pre;
            }
        }
        int[] re = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            re[i] = presum[queries[i][1] + 1] - presum[queries[i][0]];
        }
        return re;
    }
}
