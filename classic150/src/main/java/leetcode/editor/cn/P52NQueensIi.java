package leetcode.editor.cn;
//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
//
//
// Related Topics 回溯 👍 488 👎 0

//Java：52. N 皇后 II
public class P52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        boolean[][] visited;
        public int totalNQueens(int n) {
            visited = new boolean[n][n];
            backtracking(n, 0);

            return res;
        }

        public void backtracking(int n, int x) {
            if (x == n) {
                res++;
                return;
            }

            for (int j = 0; j < n; j++) {
                if (isValid(n, x, j)) {
                    visited[x][j] = true;
                    backtracking(n, x + 1);
                    visited[x][j] = false;
                }
            }
        }

        public boolean isValid(int n, int x, int y) {
            for (int i = 0; i < x; i++) {
                if (visited[i][y]) {
                    return false;
                }
            }

            int x1 = x, y1 = y;
            while (--x1 >= 0 && --y1 >= 0) {
                if (visited[x1][y1]) {
                    return false;
                }
            }

            int x2 = x, y2 = y;
            while (--x2 >= 0 && ++y2 < n) {
                if (visited[x2][y2]) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
