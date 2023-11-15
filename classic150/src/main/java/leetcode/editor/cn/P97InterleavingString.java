package leetcode.editor.cn;
//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
//
//
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
//
//
// 注意：a + b 意味着字符串 a 和 b 连接。
//
//
//
// 示例 1：
//
//
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
//
//
// 示例 2：
//
//
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
//
//
// 示例 3：
//
//
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
//
//
//
//
// 提示：
//
//
// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1、s2、和 s3 都由小写英文字母组成
//
//
//
//
// 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
//
// Related Topics 字符串 动态规划 👍 943 👎 0

//Java：97. 交错字符串
public class P97InterleavingString {
    public static void main(String[] args) {
        Solution solution = new P97InterleavingString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length();
            int n2 = s2.length();
            int n3 = s3.length();

            if (n1 + n2 != n3) return false;

            boolean[][] dp = new boolean[n1 + 1][n2 + 1];
            dp[0][0] = true;

            for (int i = 1; i <= n1; i++) {
                if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                    dp[i][0] = true;
                } else {
                    break;
                }
            }

            for (int j = 1; j <= n2; j++) {
                if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                    dp[0][j] = true;
                } else {
                    break;
                }
            }

            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    int p = i + j;

                    if (s1.charAt(i - 1) == s3.charAt(p - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }

                    if (s2.charAt(j - 1) == s3.charAt(p - 1)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                }
            }

            return dp[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
