import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int N = moveTime.length;
        int M = moveTime[0].length;
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[N][M];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]][cur[1]]) continue;
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                time = cur[2];
                break;
            }
            visited[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                pq.offer(new int[] { nx, ny, Math.max(cur[2], moveTime[nx][ny]) + 1 });
            }
        }
        return time;
    }
}
