import java.util.*;

class Solution {
    boolean solution(String s) {
        String[] strings = s.split("");
        List<String> stack = new ArrayList<>();
        if (strings[0].equals(")")) {
            return false;
        }
        stack.add(strings[0]);
        for (int i = 1; i < s.length(); i++) {
            if (strings[i].equals("(")) {
                stack.add(strings[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.remove(stack.size() - 1);
            }
        }
        return stack.isEmpty();
    }
}
