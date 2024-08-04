import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            List<Integer> slice = new ArrayList<>();
            for (int j = command[0] - 1; j < command[1]; j++) {
                slice.add(array[j]);
            }
            slice = slice.stream().sorted().collect(Collectors.toList());
            answer[i] = slice.get(command[2] - 1);
        }
        return answer;
    }
}
