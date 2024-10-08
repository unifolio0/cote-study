import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            String binaryString = Long.toBinaryString(number);
            int length = binaryString.length();
            int k = 1;
            while ((k - 1) < length) {
                k *= 2;
            }
            if (k - 1 != length) {
                binaryString = "0".repeat((k - 1) - length) + binaryString;
            }
            boolean f = f(binaryString);
            if (f) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean f(String binaryString) {
        if (binaryString.length() == 1) {
            return true;
        }
        if (binaryString.length() == 3) {
            return binaryString.equals("000") || binaryString.equals("010") || binaryString.equals("011") || binaryString.equals("111") || binaryString.equals("110");
        }
        char c = binaryString.charAt(binaryString.length() / 2);
        if (c == '0') {
            return Long.parseLong(binaryString.substring(0, binaryString.length() / 2), 2) == 0 && Long.parseLong(binaryString.substring(binaryString.length() / 2 + 1), 2) == 0;
        } else {
            return f(binaryString.substring(0, binaryString.length() / 2)) && f(binaryString.substring(binaryString.length() / 2 + 1));
        }
    }
}
