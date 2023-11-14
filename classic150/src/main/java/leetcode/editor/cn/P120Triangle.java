package leetcode.editor.cn;
//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
// 示例 1：
//
//
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
// 示例 2：
//
//
//输入：triangle = [[-10]]
//输出：-10
//
//
//
//
// 提示：
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -10⁴ <= triangle[i][j] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
//
//
// Related Topics 数组 动态规划 👍 1287 👎 0

import java.util.Arrays;
import java.util.List;

//Java：120. 三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {

            int[] dp = new int[triangle.size()];
            Arrays.fill(dp, 0x7fffffff);
            dp[0] = triangle.get(0).get(0);

            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> curLevel = triangle.get(i);
                for (int j = curLevel.size() - 1; j >= 0; j--) {
                    int preValue1 = j == 0 ? Integer.MAX_VALUE : dp[j - 1];
                    int preValue2 = dp[j];
                    dp[j] = Math.min(preValue1, preValue2) + curLevel.get(j);
                }
            }

            int res = Integer.MAX_VALUE;
            for (int value : dp) {
                res = Math.min(res, value);
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
