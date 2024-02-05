package leetcode.editor.cn;
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
//
//
//
// 示例 1：
//
//
//输入：s = "hello"
//输出："holle"
//
//
// 示例 2：
//
//
//输入：s = "leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由 可打印的 ASCII 字符组成
//
//
// Related Topics 双指针 字符串 👍 343 👎 0

//Java：345. 反转字符串中的元音字母
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            int left = 0, right = s.length() - 1;

            char[] chars = s.toCharArray();

            while (left < right) {
                while (left < right && !isMeta(chars[left])) {
                    left++;
                }
                while (left < right && !isMeta(chars[right])) {
                    right--;
                }

                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }

            return new String(chars);
        }

        public boolean isMeta(char c) {
            char lowerCase = Character.toLowerCase(c);
            if (lowerCase == 'a') {
                return true;
            } else if (lowerCase == 'e') {
                return true;
            } else if (lowerCase == 'i') {
                return true;
            } else if (lowerCase == 'o') {
                return true;
            } else if (lowerCase == 'u') {
                return true;
            } else {
                return false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
