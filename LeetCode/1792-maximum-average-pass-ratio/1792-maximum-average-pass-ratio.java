import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(this::calRatio);
        for (int[] aClass : classes) {
            pq.offer(aClass);
        }
        while (extraStudents > 0) {
            int[] poll = pq.poll();
            int[] arr = new int[] {poll[0] + 1, poll[1] + 1};
            pq.offer(arr);
            extraStudents--;
        }
        double sum = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] poll = pq.poll();
            sum += 1.0 * poll[0] / poll[1];
        }
        return sum / classes.length;
    }

    public int calRatio(int[] arr, int[] arr2) {
        double cal1 = (1.0 * (arr[0] + 1) / (arr[1] + 1)) - (1.0 * arr[0] / arr[1]);
        double cal2 = (1.0 * (arr2[0] + 1) / (arr2[1] + 1)) - (1.0 * arr2[0] / arr2[1]);
        return Double.compare(cal2, cal1);
    }
}
