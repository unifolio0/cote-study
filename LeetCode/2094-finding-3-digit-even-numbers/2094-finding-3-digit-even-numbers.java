import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        boolean[] visited = new boolean[1000];
        List<Integer> re = new ArrayList<>();
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                for (int k = 0; k < length; k++) {
                    if ((i == k) || (j == k)) continue;
                    int num = (digits[i] * 100) + (digits[j] * 10) + digits[k];
                    if (num >= 100 && num % 2 == 0 && !visited[num]) {
                        visited[num] = true;
                        re.add(num);
                    }
                }
            }
        }
        int[] ret = new int[re.size()];
        Collections.sort(re);
        for (int i = 0; i < re.size(); i++) {
            ret[i] = re.get(i);
        }
        return ret;
    }
}