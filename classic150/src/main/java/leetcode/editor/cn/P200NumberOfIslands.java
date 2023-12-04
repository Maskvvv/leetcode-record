package leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2368 👎 0

//Java：200. 岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] position = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int numIslands(char[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        grid[i][j] = '0';
                        dfs(grid, i, j);
                    }

                }
            }

            return res;
        }

        public void dfs(char[][] grid, int x, int y) {

            for (int[] p : position) {
                int nextX = x + p[0];
                int nextY = y + p[1];

                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length && grid[nextX][nextY] == '1') {
                    grid[nextX][nextY] = '0';
                    dfs(grid, nextX, nextY);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
