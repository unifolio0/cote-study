import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b - a);
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] == 1) {
                pq.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean bb = false;
        while (sb.length() < s.length()) {
            Character poll = pq.poll();
            int k = repeatLimit;
            while (count[poll - 'a'] > 0) {
                if (k == 0) {
                    Character peek = pq.peek();
                    if (peek == null) {
                        bb = true;
                        break;
                    }
                    sb.append(peek);
                    count[peek - 'a']--;
                    if (count[peek - 'a'] == 0) {
                        pq.poll();
                    }
                    k = repeatLimit;
                }
                sb.append(poll);
                count[poll - 'a']--;
                k--;
            }
            if (bb) {
                break;
            }
        }
        return sb.toString();
    }
}
