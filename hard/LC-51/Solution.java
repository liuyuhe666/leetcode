class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] col = new int[n];
        // 90°线（列）有 n 条
        boolean[] d90 = new boolean[n];
        // 45°线有 2 * n - 1 条
        boolean[] d45 = new boolean[2 * n - 1];
        // 135°线有 2 * n - 1 条
        boolean[] d135 = new boolean[2 * n - 1];
        backtracking(0, n, col, d45, d90, d135, ans);
        return ans;
    }

    private void backtracking(int r, int n, int[] col, boolean[] d45, boolean[] d90, boolean[] d135,
        List<List<String>> ans) {
        if (r == n) {
            // 生成结果
            List<String> board = new ArrayList<>(n);
            for (int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!d45[r + c] && !d90[c] && !d135[rc]) {
                col[r] = c;
                d45[r + c] = d90[c] = d135[rc] = true;
                // 回溯
                backtracking(r + 1, n, col, d45, d90, d135, ans);
                // 恢复现场
                d45[r + c] = d90[c] = d135[rc] = false;
            }
        }
    }
}
