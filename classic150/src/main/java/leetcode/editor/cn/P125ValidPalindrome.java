package leetcode.editor.cn;
//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
// 字母和数字都属于字母数字字符。
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
//
//
// 示例 2：
//
//
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
//
//
// 示例 3：
//
//
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2 * 10⁵
// s 仅由可打印的 ASCII 字符组成
//
//
// Related Topics 双指针 字符串 👍 728 👎 0

//Java：125. 验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
        char A = 'A';

        int diff = 'A' - 'a';
        char a = (char) (A - diff);
        System.out.println(a);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int diff = 'A' - 'a';

            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    sb.append((char) (c - diff));
                } else if (c >= 'a' && c <= 'z'){
                    sb.append(c);
                } else if (c >= '0' && c <= '9') {
                    sb.append(c);
                }
            }

            int n = sb.length();
            if (n == 0) return true;

            int left = 0, right = n - 1;

            while (left < right) {

                if (sb.charAt(left++) != sb.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
