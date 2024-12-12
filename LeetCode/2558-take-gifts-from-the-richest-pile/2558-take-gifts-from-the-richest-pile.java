import java.io.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        int count = k;
        while (count > 0) {
            int max = 0;
            for (int i = 1; i < gifts.length; i++) {
                if (gifts[i] > gifts[max]) {
                    max = i;
                }
            }
            gifts[max] = (int) Math.pow(gifts[max], 0.5);
            count--;
        }
        long sum = 0;
        for (int gift : gifts) {
            sum += gift;
        }
        return sum;
    }
}
