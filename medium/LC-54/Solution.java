class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null) return ans;
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return ans;
        boolean[][] vis = new boolean[m][n];
        int tol = m * n, row = 0, col = 0, index = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < tol; i++) {
            ans.add(matrix[row][col]);
            vis[row][col] = true;
            int newRow = row + dirs[index][0], newCol = col + dirs[index][1];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || vis[newRow][newCol]) {
                index = (index + 1) % 4;
            }
            row += dirs[index][0];
            col += dirs[index][1];
        }
        return ans;
    }
}