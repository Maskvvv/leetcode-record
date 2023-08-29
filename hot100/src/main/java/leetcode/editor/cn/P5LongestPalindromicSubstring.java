package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
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
// Related Topics 字符串 动态规划 👍 6749 👎 0


//Java：5. 最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 1) return s;

            char[] charArray = s.toCharArray();

            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            int maxLength = 1;
            int beginIndex = 0;
            int endIndex = 1;

            for (int j = 1; j < n; j++) {
                for (int i = 0; i < j; i++) {
                    if (charArray[j] == charArray[i] && (dp[i + 1][j - 1] || (i + 1 == j))) {
                        dp[i][j] = true;

                        if ((j - i + 1) > maxLength) {
                            maxLength = (j - i + 1);
                            beginIndex = i;
                            endIndex = j + 1;
                        }
                    }

                }

            }

            return s.substring(beginIndex, endIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
