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
// Related Topics 字符串 动态规划 👍 6925 👎 0

//Java：5. 最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("aaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            char[] chars = s.toCharArray();

            int start = 0, end = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (chars[i] == chars[j]) {
                        if (i - j + 1 <= 3) {
                            dp[j][i] = true;
                        } else if (dp[j + 1][i - 1]) {
                            dp[j][i] = true;
                        } else {
                            continue;
                        }

                        if (i - j + 1 > end - start + 1) {
                            start = j;
                            end = i;
                        }

                    }
                }
            }

            return s.substring(start, end + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
