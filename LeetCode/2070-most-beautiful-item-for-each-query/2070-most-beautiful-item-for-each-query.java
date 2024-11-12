import java.util.*;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        });
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int l = -1;
            int r = items.length;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (items[mid][0] <= target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (l == -1) {
                ans[i] = 0;
            } else {
                ans[i] = items[l][1];
            }
        }
        return ans;
    }
}
