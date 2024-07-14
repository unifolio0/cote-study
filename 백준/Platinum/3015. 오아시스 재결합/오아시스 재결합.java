import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] height = new long[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        int[] score = new int[N];
        List<Long> stack = new ArrayList<>();
        stack.add(height[0]);
        Map<Long, Integer> note = new HashMap<>();
        note.put(stack.get(0), 0);
        long sum = 0;
        for (int i = 1; i < N; i++) {
            int idx = 0;
            while (!stack.isEmpty() && stack.get(stack.size() - 1) < height[i]) {
                stack.remove(stack.size() - 1);
                idx++;
            }
            if (stack.isEmpty()) {
                score[i] = idx;
                sum += score[i];
                note.put(height[i], 0);
                stack.add(height[i]);
                continue;
            }
            if (stack.get(stack.size() - 1) == height[i]) {
                score[i] = note.get(height[i]) + idx + 1;
                note.put(height[i], score[i] - idx);
                sum += score[i];
                stack.add(height[i]);
            } else if (stack.get(stack.size() - 1) > height[i]) {
                score[i] = idx + 1;
                note.put(height[i], 1);
                sum += score[i];
                stack.add(height[i]);
            }
        }

        bw.write(String.valueOf(sum));

        br.close();

        bw.flush();
        bw.close();
    }
}
