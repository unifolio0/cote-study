import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int idx = 0;
        answer[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == answer[idx]) {
                continue;
            }
            answer[++idx] = arr[i];
        }

        return Arrays.copyOfRange(answer, 0, idx + 1);
    }
}
