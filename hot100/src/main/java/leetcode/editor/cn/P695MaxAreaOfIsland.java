package leetcode.editor.cn;
//给你一个大小为 m x n 的二进制矩阵 grid 。
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。
//
// 岛屿的面积是岛上值为 1 的单元格的数目。
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
//
//
// 示例 2：
//
//
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] 为 0 或 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1017 👎 0

import leetcode.editor.cn.utils.GridUtils;

//Java：695. 岛屿的最大面积
public class P695MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new P695MaxAreaOfIsland().new Solution();
        // TO TEST
        System.out.println(solution.maxAreaOfIsland(GridUtils.generateIntGrid("[[0,1,1],[1,1,0]]")));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;
        int res = 0;
        int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int maxAreaOfIsland(int[][] grid) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        count = 0;
                        dfs(grid, i, j);
                        res = Math.max(count, res);
                    }
                }
            }

            return res;
        }

        public void dfs(int[][] grid, int x, int y) {
            grid[x][y] = 0;
            count++;

            for (int i = 0; i < position.length; i++) {

                int nextX = x + position[i][0];
                int nextY = y + position[i][1];

                if (nextX >=0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length && grid[nextX][nextY] == 1) {
                    dfs(grid, nextX, nextY);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
