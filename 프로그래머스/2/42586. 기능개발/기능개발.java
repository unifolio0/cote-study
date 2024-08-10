import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> stack = new ArrayList<>();
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                days[i] = (100 - progresses[i]) / speeds[i];
            } else {
                days[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }
        stack.add(1);
        int idx = 0;
        for (int i = 1; i < progresses.length; i++) {
            if (days[i] <= days[idx]) {
                stack.set(stack.size() - 1, stack.get(stack.size() - 1) + 1);
            } else {
                stack.add(1);
                idx = i;
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
