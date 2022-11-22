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
// Related Topics 数组 回溯 矩阵 👍 1483 👎 0


import leetcode.editor.cn.model.GraphFactory;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST

        String graph = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]";


        System.out.println(solution.exist(GraphFactory.buildArray(graph), "ABCB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] position = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited;
        char[] wordArray;
        char[][] board;

        int m;
        int n;

        boolean res = false;

        public boolean exist(char[][] board, String word) {
            this.m = board.length;
            this.n = board[0].length;
            this.board = board;

            this.wordArray = word.toCharArray();

            visited = new boolean[m][n];


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    backtracking(i, j, 0);
                    if (res) return true;
                }
            }

            return false;
        }

        public void backtracking(int p0, int p1, int startIndex) {

            if (startIndex >= wordArray.length || p0 < 0 || p1 < 0 || p0 >= m || p1 >= n || visited[p0][p1] || board[p0][p1] != wordArray[startIndex]) {
                return;
            }

            if (startIndex == wordArray.length - 1) {
                res = true;
            }

            for (int i = 0; i < position.length; i++) {
                visited[p0][p1] = true;
                backtracking(p0 + position[i][0], p1 + position[i][1], startIndex + 1);
                visited[p0][p1] = false;
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
