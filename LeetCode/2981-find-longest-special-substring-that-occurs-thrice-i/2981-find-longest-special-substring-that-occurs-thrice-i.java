import java.io.*;

class Solution {
    public int maximumLength(String s) {
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) break;
                String sub = s.substring(i, j + 1);
                int count = 0;
                for (int k = i; k < s.length() - sub.length() + 1; k++) {
                    String a = s.substring(k, k + sub.length());
                    if (a.equals(sub)) {
                        count++;
                    }
                }
                if (count >= 3) {
                    max = Math.max(max, sub.length());
                }
            }
        }
        return max;
    }
}
