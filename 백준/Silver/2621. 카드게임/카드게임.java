import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Set<String> colors = new HashSet<>();
        int[] counts = new int[10];
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            colors.add(color);
            counts[number]++;
            if (counts[number] == 1) {
                nums.add(number);
            }
        }
        Collections.sort(nums);

        int score = 0;
        // 조건 5
        if (nums.size() == 5 && nums.get(4) - nums.get(0) == 4) {
            score = Math.max(score, nums.get(4) + 500);
        }
        if (colors.size() == 1) {
            // 조건 1
            if (nums.get(4) - nums.get(0) == 4) {
                score = Math.max(score, nums.get(4) + 900);
            }
            // 조건 4
            score = Math.max(score, nums.get(4) + 600);
        } else {
            if (nums.size() == 2) {
                // 조건 2
                if (counts[nums.get(0)] == 4) {
                    score = Math.max(score, nums.get(0) + 800);
                } else if (counts[nums.get(1)] == 4) {
                    score = Math.max(score, nums.get(1) + 800);
                }
                // 조건 3
                else if (counts[nums.get(0)] == 3) {
                    score = Math.max(score, (nums.get(0) * 10) + nums.get(1) + 700);
                } else if (counts[nums.get(1)] == 3) {
                    score = Math.max(score, (nums.get(1) * 10) + nums.get(0) + 700);
                }
            } else if (nums.size() == 3) {
                // 조건 6
                if (counts[nums.get(0)] == 3) {
                    score = Math.max(score, nums.get(0) + 400);
                } else if (counts[nums.get(1)] == 3) {
                    score = Math.max(score, nums.get(1) + 400);
                } else if (counts[nums.get(2)] == 3) {
                    score = Math.max(score, nums.get(2) + 400);
                }
                // 조건 7
                else if (counts[nums.get(0)] == 2 && counts[nums.get(1)] == 2) {
                    score = Math.max(score, nums.get(1) * 10 + nums.get(0) + 300);
                } else if (counts[nums.get(0)] == 2 && counts[nums.get(2)] == 2) {
                    score = Math.max(score, nums.get(2) * 10 + nums.get(0) + 300);
                } else if (counts[nums.get(2)] == 2 && counts[nums.get(1)] == 2) {
                    score = Math.max(score, nums.get(2) * 10 + nums.get(1) + 300);
                }
            } else if (nums.size() == 4) {
                // 조건 8
                if (counts[nums.get(0)] == 2) {
                    score = Math.max(score, nums.get(0) + 200);
                } else if (counts[nums.get(1)] == 2) {
                    score = Math.max(score, nums.get(1) + 200);
                } else if (counts[nums.get(2)] == 2) {
                    score = Math.max(score, nums.get(2) + 200);
                } else if (counts[nums.get(3)] == 2) {
                    score = Math.max(score, nums.get(3) + 200);
                }
            }
        }

        if (score == 0) {
            score = nums.get(nums.size() - 1) + 100;
        }

        bw.write(String.valueOf(score));

        bw.flush();

        bw.close();
        br.close();
    }
}
