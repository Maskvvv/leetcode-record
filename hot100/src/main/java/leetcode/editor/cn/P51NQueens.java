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
// Related Topics 数组 回溯 👍 1893 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//Java：51. N 皇后
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST

        System.out.println(solution.solveNQueens(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        Deque<String> path = new ArrayDeque<>();

        public List<List<String>> solveNQueens(int n) {

            backtracking(n, 0);

            return res;
        }

        public void backtracking(int n, int row) {
            if (row == n) {
                res.add(new ArrayList<>(path));
                return;
            }

            char[] rowArray = new char[n];
            Arrays.fill(rowArray, '.');
            for (int i = 0; i < n; i++) {
                if (isValid(n, row, i, path)) {
                    rowArray[i] = 'Q';
                    path.addLast(new String(rowArray));
                    backtracking(n, row + 1);
                    rowArray[i] = '.';
                    path.removeLast();
                }

            }

        }

        private boolean isValid(int n, int row, int j, Deque<String> path) {

            List<String> arrayList = new ArrayList<>(path);

            int j1 = j - 1, j2 = j+ 1;
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                row--;
                String s = arrayList.get(row);
                if (s.charAt(j) == 'Q') return false;

                if (j1 >= 0 && s.charAt(j1) == 'Q') return false;

                if (j2 < n && s.charAt(j2) == 'Q') return false;

                j1--;
                j2++;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
