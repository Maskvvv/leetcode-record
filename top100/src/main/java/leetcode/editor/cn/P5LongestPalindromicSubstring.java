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

            int maxLength = 0;
            int startIndex = 0;

            for (int i = 0; i < n ; i++) {
                int left = i - 1;
                int right = i + 1;
                int currentLength = 1;

                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    left--;
                    currentLength++;
                }

                while (right < n && s.charAt(right) == s.charAt(i)) {
                    right++;
                    currentLength++;
                }

                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    currentLength += 2;
                }

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = left;
                }

            }

            return s.substring(startIndex + 1, startIndex + maxLength + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
