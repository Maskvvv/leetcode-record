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
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1709 👎 0


//Java：岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] visited;
        char[][] grid;
        int x;
        int y;

        public int numIslands(char[][] grid) {
            x = grid.length;
            y = grid[0].length;
            visited = new int[x][y];
            this.grid = grid;

            int res = 0;

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (visited[i][j] == 0 && grid[i][j] == '1') {
                        res++;
                        dfs(i, j);
                    }

                }
            }

            return res;
        }

        public void dfs(int i, int j) {
            for (int[] direction : DIRECTIONS) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                visited[i][j] = 1;
                if (newX >= 0 && newY >= 0 && newX < x && newY < y && visited[newX][newY] == 0 && grid[newX][newY] == '1') {
                    dfs(newX, newY);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
