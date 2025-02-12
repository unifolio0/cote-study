import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = 0;
            int f = nums[i];
            while (f > 0) {
                k += f % 10;
                f /= 10;
            }
            int[] tmp = map.getOrDefault(k, new int[]{0, 0});
            if (nums[i] > tmp[0]) {
                tmp[1] = tmp[0];
                tmp[0] = nums[i];
            } else if (nums[i] > tmp[1]) {
                tmp[1] = nums[i];
            }
            map.put(k, tmp);
        }
        int re = -1;
        for (int[] arr : map.values()) {
            if (arr[1] == 0) continue;
            re = Math.max(re, arr[0] + arr[1]);
        }
        return re;
    }
}
