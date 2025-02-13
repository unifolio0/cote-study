import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        int count = 0;
        while (true) {
            long f = pq.poll();
            if (f >= k) break;
            long s = pq.poll();
            pq.offer(f * 2 + s);
            count++;
        }
        return count;
    }
}
