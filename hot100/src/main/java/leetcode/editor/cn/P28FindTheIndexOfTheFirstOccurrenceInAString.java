package leetcode.editor.cn;
//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
//
//
// 示例 2：
//
//
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack 和 needle 仅由小写英文字符组成
//
//
// Related Topics 双指针 字符串 字符串匹配 👍 2032 👎 0

//Java：28. 找出字符串中第一个匹配项的下标
public class P28FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new P28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        // TO TEST

        System.out.println(solution.strStr("sadbutsad", "sad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            int[] next = getNext(needle);

            char[] haystackChars = haystack.toCharArray();
            char[] needleChars = needle.toCharArray();

            int i = 0;
            int j = 0;
            while (i < haystackChars.length) {
                if (haystackChars[i] == needleChars[j]) {
                    i++;
                    j++;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        j = next[j - 1];
                    }
                }

                if (j == needleChars.length) return i - j;
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
                    prefix++;
                    next[i] = prefix;
                    i++;
                } else {
                    if (prefix == 0) {
                        next[i] = 0;
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
