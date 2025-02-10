import java.util.*;

class Solution {
    public String clearDigits(String s) {
        List<Character> stack = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                stack.add(c);
            } else {
                stack.remove(stack.size() - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
