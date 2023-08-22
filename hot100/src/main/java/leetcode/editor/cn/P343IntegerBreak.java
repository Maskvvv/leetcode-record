package leetcode.editor.cn;
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
//
// 返回 你可以获得的最大乘积 。
//
//
//
// 示例 1:
//
//
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//
// 示例 2:
//
//
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
//
//
// 提示:
//
//
// 2 <= n <= 58
//
//
// Related Topics 数学 动态规划 👍 1252 👎 0


//Java：整数拆分
public class P343IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new P343IntegerBreak().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {

            int[] dp = new int[n + 1];

            dp[0] = 0;
            dp[1] = 0;

            for (int i = 2; i < n + 1; i++) {
                int curMax = 0;
                for (int j = 1; j < i; j++) {
                    curMax =Math.max(curMax, Math.max(j * (i - j), j * dp[i - j])) ;
                }

                dp[i] = curMax;
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
