import java.util.*;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        boolean[] visit = new boolean[n + 1];
        dfs(ans, visit, n, 0);
        return ans;
    }

    private boolean dfs(int[] ans, boolean[] visit, int n, int idx) {
        if (idx == ans.length) return true;
        if (ans[idx] > 0) return dfs(ans, visit, n , idx + 1);
        for (int i = n; i >= 1; i--) {
            if (visit[i]) continue;
            if (i == 1) {
                ans[idx] = i;
                visit[i] = true;
                if (dfs(ans, visit, n, idx + 1)) return true;
                ans[idx] = 0;
                visit[i] = false;
            } else {
                int nidx = idx + i;
                if (nidx < ans.length && ans[nidx] == 0) {
                    ans[idx] = i;
                    ans[nidx] = i;
                    visit[i] = true;
                    if (dfs(ans, visit, n, idx + 1)) return true;
                    ans[idx] = 0;
                    ans[nidx] = 0;
                    visit[i] = false;
                }
            }
        }
        return false;
    }
}
