package leetcode.editor.cn;
//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
//
//
// 示例 2：
//
//
//
//
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 10⁴
// 1 <= m * n <= 10⁴
// mat[i][j] is either 0 or 1.
// mat 中至少有一个 0
//
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 639 👎 0


//Java：01 矩阵
public class P542Zero1Matrix{
    public static void main(String[] args) {
        Solution solution = new P542Zero1Matrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int n = mat.length, m = mat[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 1) {
                        mat[i][j] = 1000;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i - 1 >= 0) {
                        mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i + 1 < n) {
                        mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                    }
                    if (j + 1 < m) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                    }
                }
            }

            return mat;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
