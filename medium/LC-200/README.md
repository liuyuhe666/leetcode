# 岛屿数量

## DFS

解题思路：

遍历整个二维数组，如果该位置为 `1`，则从该位置开始进行深度优先搜索，在搜索的过程中，将搜索到的 `1` 改为 `0`。

最终岛屿的数量就是深度优先搜索的次数。

具体代码如下：

```java
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
```

## BFS

解题思路：

和深度优先搜索类似，遍历整个二维数组，如果该位置的元素为 `1`，则将其加入搜索队列，进行广度优先搜索，在搜索过程中，将搜索到的 `1` 标记为 `0`，直到搜索队列为空，搜索结束。

最终岛屿的数量就是广度优先搜索的次数。

具体代码如下：

```java
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

```
