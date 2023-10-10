package leetcode.editor.cn;
//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。
//
//
//
// 示例 1:
//
//
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
//
//
// 示例 2:
//
//
//输入: s = "aba"
//输出: false
//
//
// 示例 3:
//
//
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
//
//
//
//
// 提示：
//
//
//
//
//
// 1 <= s.length <= 10⁴
// s 由小写英文字母组成
//
//
// Related Topics 字符串 字符串匹配 👍 1060 👎 0

//Java：459. 重复的子字符串
public class P459RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new P459RepeatedSubstringPattern().new Solution();
        // TO TEST
        System.out.println(solution.repeatedSubstringPattern("aba"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s.length() == 1) return false;

            String masterString = (s + s).substring(1, s.length() * 2 - 1);
            String subString = s;

            int i = indexOf(masterString, subString);
            return i != -1;
        }

        private int indexOf(String masterString, String subString) {
            int[] next = getNext(subString);

            char[] masterChars = masterString.toCharArray();
            char[] subChars = subString.toCharArray();
            int i = 0;
            int j = 0;

            while (i < masterChars.length) {
                if (masterChars[i] == subChars[j]) {
                    i++;
                    j++;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        j = next[j - 1];
                    }
                }

                if (j == subChars.length) return i - j;
            }
            return -1;
        }

        private int[] getNext(String subString) {
            char[] chars = subString.toCharArray();
            int[] next = new int[chars.length];

            int i = 1;
            int prefix = 0;

            while (i < chars.length) {
                if (chars[i] == chars[prefix]) {
                    next[i] = prefix + 1;
                    prefix++;
                    i++;
                } else {
                    if (prefix == 0) {
                        i++;
                    } else {
                        prefix = next[prefix - 1];
                    }
                }
            }

            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
