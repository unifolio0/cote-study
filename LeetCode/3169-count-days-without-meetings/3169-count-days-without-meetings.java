import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (m1, m2) -> {
            if (m1[0] != m2[0]) {
                return m1[0] - m2[0];
            }
            return m1[1] - m2[1];
        });
        int count = meetings[0][0] - 1;
        int idx = 0;
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[idx][1] >= meetings[i][0]) {
                if (meetings[idx][1] < meetings[i][1]) {
                    idx = i;
                }
                continue;
            }
            count += meetings[i][0] - meetings[idx][1] - 1;
            idx = i;
        }
        if (meetings[idx][1] < days) {
            count += days - meetings[idx][1];
        }
        return count;
    }
}
