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
// Related Topics 数组 回溯 矩阵 👍 1280 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
        //char[] path = new char[10];
        //System.out.println(new String(path));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Deque<Character> path = new ArrayDeque<>();

        public boolean exist(char[][] board, String word) {

            char[] wordArray = word.toCharArray();


            return backtracking(board, wordArray, 0, 0);

        }

        public Boolean backtracking(char[][] board, char[] wordArray, int x, int y) {


            if (path.size() == wordArray.length) {
                return true;
            }

            boolean right = false;
            boolean down = false;

            for (int i = x; i < board.length; i++) {
                for (int j = y; j < board[0].length; j++) {

                    if (board[x][y] != wordArray[path.size() + 1]) {
                        return false;
                    }

                    path.addLast(board[i][j]);
                    right = backtracking(board, wordArray, x + 1, y);
                    down = backtracking(board, wordArray, x, y + 1);
                    path.removeLast();


                }
            }

            return right ? right : down;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
