class Solution {
    int MOD = 1000000007;
    int[] dp;

    public int numTilings(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        return f(n);
    }

    private int f(int n) {
        if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) return dp[n];
        dp[n] = ((f(n - 1) % MOD) + (f(n - 2) % MOD)) % MOD;
        for (int i = n - 4; i >= 0; i -= 2) {
            dp[n] = (dp[n] + (f(i) * 2) % MOD) % MOD;
        }
        for (int i = n - 3; i >= 0; i -= 2) {
            dp[n] = (dp[n] + (f(i) * 2) % MOD) % MOD;
        }
        return dp[n] % MOD;
    }
}
