import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        if (rocks.length == n) return distance;
        Arrays.sort(rocks);
        int l = 1;
        int r = distance;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            int tmp = 0;
            int s = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - s >= mid) {
                    s = rocks[i];
                } else {
                    tmp++;
                }
            }
            if (distance - s < mid) tmp++;
            if (tmp > n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }
}