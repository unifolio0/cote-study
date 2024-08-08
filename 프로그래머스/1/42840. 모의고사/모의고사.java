import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] s = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % 5]) {
                s[0]++;
            }
            if (answers[i] == p2[i % 8]) {
                s[1]++;
            }
            if (answers[i] == p3[i % 10]) {
                s[2]++;
            }
        }
        int max = Arrays.stream(s).max().getAsInt();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (s[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}
