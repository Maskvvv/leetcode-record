package leetcode.editor.cn;
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//
// 示例 2：
//
//
//输入：board = [["X"]]
//输出：[["X"]]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 为 'X' 或 'O'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1060 👎 0

//Java：130. 被围绕的区域
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] position = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited;
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O' && !visited[i][0]) {
                    visited[i][0] = true;
                    dfs1(board, i, 0);
                }

                if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                    visited[i][n - 1] = true;
                    dfs1(board, i, n - 1);
                }
            }

            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O' && !visited[0][j]) {
                    visited[0][j] = true;
                    dfs1(board, 0, j);
                }

                if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                    visited[m - 1][j] = true;
                    dfs1(board, m - 1, j);
                }
            }

            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        board[i][j] = 'X';
                        visited[i][j] = true;
                        dfs(board, i, j);
                    }
                }
            }
        }

        public void dfs(char[][] grid, int x, int y) {
            for (int[] p : position) {
                int nextX = x + p[0];
                int nextY = y + p[1];

                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length && !visited[nextX][nextY] && grid[nextX][nextY] == 'O') {
                    grid[nextX][nextY] = 'X';
                    visited[nextX][nextY] = true;
                    dfs(grid, nextX, nextY);
                }
            }
        }

        public void dfs1(char[][] grid, int x, int y) {
            for (int[] p : position) {
                int nextX = x + p[0];
                int nextY = y + p[1];

                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length && !visited[nextX][nextY] && grid[nextX][nextY] == 'O') {
                    visited[nextX][nextY] = true;
                    dfs1(grid, nextX, nextY);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
