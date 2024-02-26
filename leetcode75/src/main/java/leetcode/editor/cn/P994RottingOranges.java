package leetcode.editor.cn;
//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一：
//
//
// 值 0 代表空单元格；
// 值 1 代表新鲜橘子；
// 值 2 代表腐烂的橘子。
//
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
//
//
// 示例 2：
//
//
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
//
//
// 示例 3：
//
//
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] 仅为 0、1 或 2
//
//
// Related Topics 广度优先搜索 数组 矩阵 👍 814 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

//Java：994. 腐烂的橘子
public class P994RottingOranges {
    public static void main(String[] args) {
        Solution solution = new P994RottingOranges().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            int goodOranges = 0;

            Deque<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        goodOranges++;
                    } else if (grid[i][j] == 2){
                        queue.offerLast(new int[]{i, j});
                    }
                }
            }

            int[][] positions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!queue.isEmpty()) {
                if (goodOranges == 0) break;

                Deque<int[]> newQueue = new ArrayDeque<>();

                while (!queue.isEmpty()) {
                    int[] point = queue.pollFirst();
                    for (int[] position : positions) {
                        int newX = point[0] + position[0];
                        int newY = point[1] + position[1];
                        if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == 1) {
                            grid[newX][newY] = 2;
                            goodOranges--;

                            newQueue.offerLast(new int[]{newX, newY});
                        }
                    }
                }

                queue = newQueue;
                res++;
            }

            if (goodOranges == 0) {
                return res;
            } else {
                return -1;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
