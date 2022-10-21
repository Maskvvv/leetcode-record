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

        char[] wordArray;
        int rows;
        int cols;
        int n;
        int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited;


        public boolean exist(char[][] board, String word) {

            wordArray = word.toCharArray();
            rows = board.length;
            cols = board[0].length;
            n = word.length();
            visited = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (backtracking(i, j, 0, board)) {
                        return true;
                    }
                }
            }

            return false;

        }

        public boolean backtracking(int x, int y, int start, char[][] board) {
            if (start == n - 1) {
                return board[x][y] == wordArray[start];
            }

            if (board[x][y] == wordArray[start]) {
                visited[x][y] = true;
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && !visited[newX][newY]) {
                        if (backtracking(newX, newY, start + 1, board)) {
                            return true;
                        }
                    }

                }
                visited[x][y] = false;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
