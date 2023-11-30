package leetcode.editor.cn;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"SEE"
//输出：true
//
//
// 示例 3：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCB"
//输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
//
// Related Topics 数组 回溯 矩阵 👍 1724 👎 0

import leetcode.editor.cn.utils.GraphFactory;

//Java：79. 单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
        System.out.println(solution.exist(GraphFactory.buildArray("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] position = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean res = false;
        boolean[][] visited;
        int m;
        int n;

        public boolean exist(char[][] board, String word) {
            char[] chars = word.toCharArray();
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    backtracking(board, chars, 0, i, j);

                    if (res) {
                        return true;
                    }
                }
            }

            return false;
        }

        public void backtracking(char[][] board, char[] chars, int index, int x, int y) {
            if (board[x][y] != chars[index]) {
                return;
            }

            if (index == chars.length - 1) {
                res = true;
                return;
            }

            visited[x][y] = true;
            for (int[] p : position) {
                int nextX = x + p[0];
                int nextY = y + p[1];

                if (nextY >= 0 && nextX >= 0 && nextX < m && nextY < n && !visited[nextX][nextY]) {
                    backtracking(board, chars, index + 1, nextX, nextY);
                }
            }
            visited[x][y] = false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
