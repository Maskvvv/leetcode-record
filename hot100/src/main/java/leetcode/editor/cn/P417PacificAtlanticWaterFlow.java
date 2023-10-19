package leetcode.editor.cn;
//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。
//
//
//
// 示例 1：
//
//
//
//
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//
//
// 示例 2：
//
//
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
//
//
//
//
// 提示：
//
//
// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 10⁵
//
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 641 👎 0

import leetcode.editor.cn.utils.GridUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：417. 太平洋大西洋水流问题
public class P417PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new P417PacificAtlanticWaterFlow().new Solution();
        // TO TEST
        System.out.println(solution.pacificAtlantic(GridUtils.generateIntGrid("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] isPacific;
        boolean[][] isAtlantic;
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            isPacific = new boolean[heights.length][heights[0].length];
            isAtlantic = new boolean[heights.length][heights[0].length];

            for (int i = 0; i < heights.length; i++) {
                dfs(heights, i, 0, isPacific);
                dfs(heights, i, heights[0].length - 1, isAtlantic);
            }

            for (int j = 0; j < heights[0].length; j++) {
                dfs(heights, 0, j, isPacific);
                dfs(heights, heights.length - 1, j, isAtlantic);
            }

            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < heights[0].length; j++) {

                    if (isAtlantic[i][j] && isPacific[i][j]) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }

            return res;
        }

        public void dfs(int[][] heights, int x, int y, boolean[][] isOcean) {
            isOcean[x][y] = true;

            for (int i = 0; i < position.length; i++) {
                int nextX = x + position[i][0];
                int nextY = y + position[i][1];

                if (nextX >= 0 && nextY >= 0 && nextX < heights.length && nextY < heights[0].length
                        && !isOcean[nextX][nextY] && heights[nextX][nextY] >= heights[x][y]) {

                    dfs(heights, nextX, nextY, isOcean);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
