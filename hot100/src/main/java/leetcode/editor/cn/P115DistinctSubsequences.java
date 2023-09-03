package leetcode.editor.cn;
//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
//
// 题目数据保证答案符合 32 位带符号整数范围。
//
//
//
// 示例 1：
//
//
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit
//
// 示例 2：
//
//
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 1000
// s 和 t 由英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 1112 👎 0


//Java：115. 不同的子序列
public class P115DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new P115DistinctSubsequences().new Solution();
        // TO TEST

        System.out.println(solution.numDistinct(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();

            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[m][n] == 123610048 ? -1 : dp[m][n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
