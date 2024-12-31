import java.util.*;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int size = days[days.length - 1];
        int[] dp = new int[size + 1];
        int idx = 0;
        for (int i = 1; i <= size; i++) {
            if (i == days[idx]) {
                dp[i] = Math.min(Math.min(dp[i - 1] + costs[0], dp[Math.max(i - 7, 0)] + costs[1]), dp[Math.max(i - 30, 0)] + costs[2]);
                idx++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[size];
    }
}
