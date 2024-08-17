class Solution {
    public void gameOfLife(int[][] board) {
        int[] dirs = {0, -1, 1};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0; // 统计相邻位置活细胞的数量
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (!(dirs[x] == 0 && dirs[y] == 0)) {
                            int r = i + dirs[x];
                            int c = j + dirs[y];
                            // 相邻位置的细胞是否存活
                            if ((r < m && r >= 0) && (c < n && c >= 0)
                                && (Math.abs(board[r][c]) == 1)) {
                                ++cnt;
                            }
                        }
                    }
                }
                // 规则 1 或 规则 3
                if ((board[i][j] == 1) && (cnt < 2 || cnt > 3)) {
                    board[i][j] = -1;
                }
                // 规则 4
                if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }
        // 统一状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}