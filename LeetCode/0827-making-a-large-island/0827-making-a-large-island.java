import java.util.*;

class Solution {

    int maxSize = 0;
    boolean[][] visited;
    int size;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] cGrid;
    Map<Integer, Integer> sizeMap;
    int count = 0;

    public int largestIsland(int[][] grid) {
        size = grid.length;
        sizeMap = new HashMap<>();
        visited = new boolean[size][size];
        cGrid = new int[size][size];
        int idx = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) visited[i][j] = true;
                if (visited[i][j]) continue;
                dfs(grid, i, j, idx);
                sizeMap.put(idx, count);
                maxSize = Math.max(maxSize, count);
                count = 0;
                idx++;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 1) continue;
                Set<Integer> set = new HashSet<>();
                int tSize = 1;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                    if (cGrid[nx][ny] == 0) continue;
                    if (set.contains(cGrid[nx][ny])) continue;
                    set.add(cGrid[nx][ny]);
                    tSize += sizeMap.get(cGrid[nx][ny]);
                }
                maxSize = Math.max(maxSize, tSize);
            }
        }
        return maxSize;
    }

    private void dfs(int[][] grid, int x, int y, int idx) {
        cGrid[x][y] = idx;
        count++;
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
            if (visited[nx][ny]) continue;
            if (grid[nx][ny] == 0) continue;
            dfs(grid, nx, ny, idx);
        }
    }
}
