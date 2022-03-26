package leetcode.editor.cn;
//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
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
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
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
// Related Topics 广度优先搜索 数组 矩阵 👍 524 👎 0


import java.util.LinkedList;
import java.util.Queue;

//Java：腐烂的橘子
public class P994RottingOranges{
    public static void main(String[] args) {
        Solution solution = new P994RottingOranges().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {

            int m = grid.length, n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();

            int goodApple = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        goodApple++;
                    }
                }
            }

            if (goodApple == 0) return 0;

            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            int res = 0;

            while (!queue.isEmpty()) {
                Queue<int[]> queue2 = new LinkedList<>();

                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    int x = point[0], y = point[1];
                    for (int i = 0; i < 4; i++) {
                        int newX = x + dx[i], newY = y + dy[i];
                        if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == 1) {
                            queue2.add(new int[]{newX, newY});
                            grid[newX][newY] = 2;
                            goodApple--;
                        }

                    }
                }

                res++;
                queue = queue2;
            }

            return goodApple == 0 ? res : -1;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
