import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int length = citations.length;
        int[] re = new int[10_001];
        for (int num : citations) {
            re[num]++;
        }
        int answer = 0;
        for (int i = 0; i < length + 1; i++) {
            int sum = 0;
            for (int s = i; s < 10_001; s++) {
                sum += re[s];
            }
            if (sum >= i) {
                answer = i;
            }
        }
        return answer;
    }
}
