package leetcode.editor.cn;
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
//
//
// 示例 2：
//
//
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -2³¹ <= matrix[i][j] <= 2³¹ - 1
//
//
//
//
// 进阶：
//
//
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
// 你能想出一个仅使用常量空间的解决方案吗？
//
//
// Related Topics 数组 哈希表 矩阵 👍 965 👎 0

import leetcode.editor.cn.utils.GridUtils;

//Java：73. 矩阵置零
public class P73SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new P73SetMatrixZeroes().new Solution();
        // TO TEST

        solution.setZeroes(GridUtils.generateIntGrid("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean firstCol = false;
            boolean firstRow = false;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;

                        if (i == 0) {
                            firstRow = true;
                        }

                        if (j == 0) {
                            firstCol = true;
                        }
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firstRow) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[0][j] = 0;
                }
            }

            if (firstCol) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
