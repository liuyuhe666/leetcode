class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    grid[i][j] = '0';
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i * n + j);
                    while (!q.isEmpty()) {
                        int index = q.poll();
                        int x = index / n, y = index % n;
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            q.offer((x - 1) * n + y);
                            grid[x - 1][y] = '0';
                        }
                        if (x + 1 < m && grid[x + 1][y] == '1') {
                            q.offer((x + 1) * n + y);
                            grid[x + 1][y] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            q.offer(x * n + y - 1);
                            grid[x][y - 1] = '0';
                        }
                        if (y + 1 < n && grid[x][y + 1] == '1') {
                            q.offer(x * n + y + 1);
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }
}