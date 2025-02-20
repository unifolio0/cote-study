import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int N = nums[0].length();
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        return dfs(set, "", 0, N);
    }

    private String dfs(Set<String> set, String num, int d, int N) {
        if (d == N) {
            if (set.contains(num)) {
                return null;
            }
            return num;
        }
        String[] tmp = {"0", "1"};
        for (int i = 0; i < tmp.length; i++) {
            String res = dfs(set, num + tmp[i], d + 1, N);
            if (res != null) {
                return res;
            }
        }
        return null;
    }
}
