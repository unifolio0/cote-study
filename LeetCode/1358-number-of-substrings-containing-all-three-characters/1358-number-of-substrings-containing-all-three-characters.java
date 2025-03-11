import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int[] tmp = new int[3];
        Arrays.fill(tmp, -1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            tmp[s.charAt(i) - 'a'] = i;
            ans += Math.min(tmp[0], Math.min(tmp[1], tmp[2])) + 1;
        }
        return ans;
    }
}