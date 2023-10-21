package leetcode.editor.cn;
//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
//
//
//
// 示例 1:
//
//
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
//
//
// 示例 2:
//
//
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。
//
// 示例 3:
//
//
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。
//
//
//
// 提示：
//
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 500
// grid[i][j] 为 0 或 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 375 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：827. 最大人工岛
public class P827MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new P827MakingALargeIsland().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        int no = 2;
        Map<Integer, Integer> islandMap = new HashMap<>();
        int res = 0;
        public int largestIsland(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        no++;
                        count++;
                        grid[i][j] = no;
                        dfs(grid, i, j);

                        if (count > 0) {
                            islandMap.put(no, count);
                            res = Math.max(res, count);
                            count = 0;
                        }
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            int currentSize = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        for (int offset = 0; offset < position.length; offset++) {
                            int nextX = i + position[offset][0];
                            int nextY = j + position[offset][1];

                            if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                                    && grid[nextX][nextY] > 0 && !set.contains(grid[nextX][nextY])) {
                                currentSize += islandMap.get(grid[nextX][nextY]);
                                set.add(grid[nextX][nextY]);
                            }
                        }

                        if (currentSize > 0) {
                            res = Math.max(res, currentSize + 1);
                            set.clear();
                            currentSize = 0;
                        }
                    }
                }
            }

            return res;

        }

        public void dfs(int[][] grid, int x, int y) {
            for (int i = 0; i < position.length; i++) {
                int nextX = x + position[i][0];
                int nextY = y + position[i][1];

                if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
                        && grid[nextX][nextY] == 1) {

                    grid[nextX][nextY] = no;
                    count++;
                    dfs(grid, nextX, nextY);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
