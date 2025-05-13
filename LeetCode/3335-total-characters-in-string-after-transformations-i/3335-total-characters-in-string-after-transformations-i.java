class Solution {
    int[][] dp;
    int mod = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        dp = new int[26][t + 1];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = (count + f(s.charAt(i) - 'a', t) % mod) % mod;
        }
        return count;
    }

    private int f(int c, int t) {
        if (t < 1) return 1;
        if (dp[c][t] != 0) return dp[c][t] % mod;
        if (c == 25) {
            dp[c][t] = (f(0, t - 1) + f(1, t - 1)) % mod;
        } else {
            dp[c][t] = f(c + 1, t - 1) % mod;
        }
        return dp[c][t] % mod;
    }
}
