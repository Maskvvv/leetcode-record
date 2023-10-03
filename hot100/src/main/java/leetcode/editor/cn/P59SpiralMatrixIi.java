package leetcode.editor.cn;
//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
//
// Related Topics 数组 矩阵 模拟 👍 1176 👎 0

import leetcode.editor.cn.utils.GridUtils;

//Java：59. 螺旋矩阵 II
public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST


        GridUtils.print(solution.generateMatrix(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];

            int startX = 0, startY = 0;
            int offset = 1;
            int count = 1;
            for (int level = 0; level <= n / 2; level++) {
                for (int j = startY; j < n - offset; j++) {
                    res[startX][j] = count;
                    count++;
                }

                for (int i = startX; i < n - offset; i++) {
                    res[i][n - offset] = count;
                    count++;
                }

                for (int j = n - offset; j > startY; j--) {
                    res[n - offset][j] = count;
                    count++;
                }
                for (int i = n - offset; i > startX; i--) {
                    res[i][startY] = count;
                    count++;
                }

                offset++;
                startX++;
                startY++;
            }

            if (n % 2 == 1) {
                res[n / 2][n / 2] = count;
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
