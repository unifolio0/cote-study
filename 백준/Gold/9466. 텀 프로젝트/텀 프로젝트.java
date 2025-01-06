import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static boolean[] finished;
    static int[] nums;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            nums = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            bw.write(n - count + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    private static void dfs(int i) {
        if (visited[i]) return;
        visited[i] = true;
        int next = nums[i];
        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count++;
                for (int j = next; j != i; j = nums[j]) {
                    count++;
                }
            }
        }
        finished[i] = true;
    }
}
