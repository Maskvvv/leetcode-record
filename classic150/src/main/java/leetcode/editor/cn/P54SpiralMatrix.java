package leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
//
// Related Topics 数组 矩阵 模拟 👍 1581 👎 0

import leetcode.editor.cn.utils.GraphFactory;

import java.util.ArrayList;
import java.util.List;

//Java：54. 螺旋矩阵
public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
        System.out.println(solution.spiralOrder(GraphFactory.buildIntArray("[[1,2,3],[4,5,6],[7,8,9]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();

            int left = 0;
            int right = matrix[0].length - 1;
            int top = 0;
            int bottom = matrix.length - 1;

            while (left <= right && top <= bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
                if (top > bottom) break;

                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                if (left > right) break;

                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                if (top > bottom) break;


                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
