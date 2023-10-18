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
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1039 👎 0

//Java：130. 被围绕的区域
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited;

        public void solve(char[][] board) {
            visited = new boolean[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 'O' && !visited[i][0]) {
                    dfs(board, i, 0);
                }
                if (board[i][board[0].length - 1] == 'O' && !visited[i][board[0].length - 1]) {
                    dfs(board, i, board[0].length - 1);
                }
            }

            for (int j = 0; j < board[0].length; j++) {
                if (board[0][j] == 'O' && !visited[0][j]) {
                    dfs(board, 0, j);
                }
                if (board[board.length - 1][j] == 'O' && !visited[board.length - 1][j]) {
                    dfs(board, board.length - 1, j);
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (!visited[i][j] && board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }

                }
            }

        }


        public void dfs(char[][] board, int x, int y) {

            visited[x][y] = true;

            for (int i = 0; i < position.length; i++) {
                int nextX = x + position[i][0];
                int nextY = y + position[i][1];

                if (nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board[0].length && !visited[nextX][nextY] && board[nextX][nextY] == 'O') {
                    dfs(board, nextX, nextY);
                }

            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
