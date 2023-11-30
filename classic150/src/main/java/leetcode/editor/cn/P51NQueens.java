package leetcode.editor.cn;
//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 1979 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：51. N 皇后
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        StringBuilder s = new StringBuilder();

        public List<List<String>> solveNQueens(int n) {
            for (int i = 0; i < n; i++) {
                s.append('.');
            }

            backtracking(n, 0);

            return res;
        }

        public void backtracking(int n, int x) {
            if (x == n) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int j = 0; j < n; j++) {
                if (isValid(n, x, j)) {
                    StringBuilder stringBuilder = new StringBuilder(s);
                    stringBuilder.setCharAt(j, 'Q');
                    path.add(stringBuilder.toString());

                    backtracking(n, x + 1);

                    path.remove(path.size() - 1);
                }
            }
        }

        public boolean isValid(int n, int x, int y) {
            for (int i = 0; i < x; i++) {
                if (path.get(i).charAt(y) == 'Q') {
                    return false;
                }
            }

            int x1 = x, y1 = y;
            while (--x1 >= 0 && --y1 >= 0) {
                if (path.get(x1).charAt(y1) == 'Q') {
                    return false;
                }
            }

            int x2 = x, y2 = y;
            while (--x2 >= 0 && ++y2 < n) {
                if (path.get(x2).charAt(y2) == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
