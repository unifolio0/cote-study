import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        boolean[] visit =  new boolean[n];
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            visit[arr[i]] = true;
            boolean t = true;
            for (int j = 0; j <= i; j++) {
                if (!visit[j]) {
                    t = false;
                    break;
                }
            }
            if (t) {
                count++;
            }
        }
        return count;
    }
}
