import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 1;
        long r = (long) times[times.length - 1] * n;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            long tmp = 0;
            for (int time : times) {
                tmp += mid / time;
            }
            if (tmp < n) {
                l = mid;
            } else {
                r = mid;
            }
        }
        long answer = r;
        return answer;
    }
}