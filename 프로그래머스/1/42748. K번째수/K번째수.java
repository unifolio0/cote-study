import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] slice = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(slice);
            answer[i] = slice[command[2] - 1];
        }
        return answer;
    }
}
