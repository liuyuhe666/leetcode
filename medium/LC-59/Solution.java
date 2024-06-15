class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        int i = 1, row = 0, col = 0, index = 0;
        while (i <= n * n) {
            ans[row][col] = i++;
            int nextRow = row + dirs[index][0];
            int nextCol = col + dirs[index][1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n || ans[nextRow][nextCol] != 0) {
                // 顺时针旋转
                index = (index + 1) % 4;
            }
            row = row + dirs[index][0];
            col = col + dirs[index][1];
        }
        return ans;
    }
}