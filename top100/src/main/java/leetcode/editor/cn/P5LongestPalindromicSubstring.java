package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 5841 👎 0


//Java：最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n < 2) return s;

            int maxLength = 1;
            int startIndex = 0;
            int endIndex = 1;

            boolean[][] dp = new boolean[n][n];

            for (int r = 1; r < n ; r++) {
                for (int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;

                        if (r - l + 1 > maxLength) {
                            maxLength = r - l + 1;
                            startIndex = l;
                            endIndex = r + 1;
                        }
                    }

                }

            }

            return s.substring(startIndex, endIndex);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
