import java.util.*;

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int c = 0;
        int re = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (colors[i % n] != colors[(i + 1) % n]) {
                c++;
            } else {
                c = 1;
            }
            if (i >= n && c >= k) {
                re++;
            }
        }
        return re;
    }
}