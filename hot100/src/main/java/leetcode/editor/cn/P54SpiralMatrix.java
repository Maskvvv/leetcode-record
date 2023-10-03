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
// Related Topics 数组 矩阵 模拟 👍 1501 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：54. 螺旋矩阵
public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

            int startX = 0, endX = matrix.length - 1;
            int startY = 0, endY = matrix[0].length - 1;
            while (true) {
                for (int j = startY; j <= endY; j++) {
                    res.add(matrix[startX][j]);
                }
                if (++startX > endX) break;

                for (int i = startX; i <= endX; i++) {
                    res.add(matrix[i][endY]);
                }
                if (--endY < startY) break;

                for (int j = endY; j >= startY; j--) {
                    res.add(matrix[endX][j]);
                }
                if (--endX < startX) break;

                for (int i = endX; i >= startX; i--) {
                    res.add(matrix[i][startY]);
                }
                if (++startY > endY) break;
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
