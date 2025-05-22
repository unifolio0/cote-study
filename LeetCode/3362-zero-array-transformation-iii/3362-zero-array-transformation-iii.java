import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] subs = new int[nums.length + 1];
        int idx = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= subs[i];
            while (idx < queries.length && queries[idx][0] <= i) {
                pq.offer(queries[idx++][1]);
            }
            while (!pq.isEmpty() && pq.peek() >= i && sum < nums[i]) {
                subs[pq.poll() + 1] += 1;
                sum += 1;
            }
            if (sum < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}
