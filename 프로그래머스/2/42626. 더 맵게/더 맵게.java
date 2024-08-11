import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        int answer = 0;
        while (true) {
            if (pq.size() == 1 && pq.peek() < K) {
                break;
            }
            Integer num1 = pq.poll();
            if (num1 >= K) {
                return answer;
            }
            Integer num2 = pq.poll();
            int sc = num1 + (num2 * 2);
            pq.offer(sc);
            answer++;
        }
        return -1;
    }
}