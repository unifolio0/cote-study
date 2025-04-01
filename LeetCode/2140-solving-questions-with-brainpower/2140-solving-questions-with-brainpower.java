import java.util.Arrays;

class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return f(0, questions);
    }

    private long f(int d, int[][] questions) {
        if (d >= questions.length) {
            return 0;
        }
        if (dp[d] != -1) return dp[d];
        dp[d] = Math.max(f(d + 1, questions), f(d + questions[d][1] + 1, questions) + questions[d][0]);
        return dp[d];
    }
}
