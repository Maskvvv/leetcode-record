package leetcode.editor.cn;
//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//
//
// 示例 2：
//
//
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid[i][j] 的值为 0 或 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 239 👎 0

import leetcode.editor.cn.utils.GridUtils;

//Java：1020. 飞地的数量
public class P1020NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new P1020NumberOfEnclaves().new Solution();
        // TO TEST

        System.out.println(solution.numEnclaves(GridUtils.generateIntGrid("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        int count = 0;
        boolean isFly = true;
        int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int numEnclaves(int[][] grid) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        isFly = true;
                        count = 0;
                        dfs(grid, i, j);
                        if (isFly) {
                            res += count;
                        }
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

                if (nextX >= grid.length || nextY >= grid[0].length || nextX < 0 || nextY < 0) {
                    isFly = false;
                    continue;
                }

                if (grid[nextX][nextY] == 0) {
                    continue;
                }

                dfs(grid, nextX, nextY);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
