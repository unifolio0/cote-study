import java.util.*;

class Solution {
    public int[] minOperations(String boxes) {
        int[] nums = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            nums[i] = boxes.charAt(i) - '0';
        }
        int[] answers = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == 1) {
                    count += Math.abs(j - i);
                }
            }
            answers[i] = count;
        }
        return answers;
    }
}
