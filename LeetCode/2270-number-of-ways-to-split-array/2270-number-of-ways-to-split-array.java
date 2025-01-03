import java.util.*;

class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] presums = new long[nums.length];
        presums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            presums[i] = nums[i] + presums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (presums[i] >= presums[nums.length - 1] - presums[i]) {
                count++;
            }
        }
        return count;
    }
}
