package leetcode.editor.cn;
//编写一个程序，通过填充空格来解决数独问题。
//
// 数独的解法需 遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
//
//
//
//
//
//
//
// 提示：
//
//
// board.length == 9
// board[i].length == 9
// board[i][j] 是一位数字或者 '.'
// 题目数据 保证 输入数独仅有一个解
//
//
// Related Topics 数组 哈希表 回溯 矩阵 👍 1714 👎 0


import leetcode.editor.cn.utils.GraphFactory;

import java.util.Arrays;

//Java：37. 解数独
public class P37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // TO TEST

        solution.solveSudoku(GraphFactory.buildArray("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] res = new char[9][9];
        public void solveSudoku(char[][] board) {

            backtracking(board, 0);

            for (char[] re : res) {
                for (char c : re) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
        }

        public void backtracking(char[][] board, int row) {

            if (row == 9) return;

            for (int j = 0; j < 9; j++) {
                for (int num = 0; num < 9; num++) {

                    if (board[row][j] == '.' && isValid(board, row, j, (char) ('1' + num))) {
                        if (row == 8 && j == 8) {
                            res = Arrays.copyOf(board, 9);
                            return;
                        }

                        board[row][j] = (char) ('1' + num);
                        backtracking(board, row + 1);
                        board[row][j] = '.';

                    }

                }
            }
        }

        private boolean isValid(char[][] board, int row, int col, char num) {
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == num || board[row][i] == num) return false;
                if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == num) return false;
                if (row - 1 >= 0 && col + 1 < 9 && board[row - 1][col + 1] == num) return false;
                if (row + 1 < 9 && col - 1 >= 0 && board[row + 1][col - 1] == num) return false;
                if (row + 1 < 9 && col + 1 < 9  && board[row + 1][col + 1] == num) return false;
            }

            //int r = (row + 3) % 3 + row;
            //int c = (col + 3) % 3 + col;
            //for (int i = r; i > r - 3; i--) {
            //    for (int j = c; j > c - 3; j--) {
            //        if (board[i][j] == num) return false;
            //    }
            //}

            return true;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
