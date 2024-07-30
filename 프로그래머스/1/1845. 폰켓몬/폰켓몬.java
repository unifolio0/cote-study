import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int length = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int len = set.size();
        return Math.min(len, length);
    }
}