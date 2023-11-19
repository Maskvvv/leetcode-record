package leetcode.editor.cn;
//给定一个整数 n ，返回 n! 结果中尾随零的数量。
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
//
//
// 示例 2：
//
//
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
//
//
// 示例 3：
//
//
//输入：n = 0
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 10⁴
//
//
//
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
//
// Related Topics 数学 👍 802 👎 0

//Java：172. 阶乘后的零
public class P172FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new P172FactorialTrailingZeroes().new Solution();
        // TO TEST
        solution.trailingZeroes(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int res = 0;

            for (int i = 5; i <= n; i += 5) {
                for (int j = i; j % 5 == 0 ; j /= 5) {
                    res++;

                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
