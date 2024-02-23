package leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
//
// Related Topics 字典树 字符串 👍 3051 👎 0

//Java：14. 最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";

            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {

                prefix = getMaxPrefix(prefix, strs[i]);
                if (prefix.length() == 0) return "";

            }

            return prefix;
        }

        public String getMaxPrefix(String s1, String s2) {
            int length = Math.min(s1.length(), s2.length());
            if (length == 0) return "";

            int index = 0;
            while (index < length) {
                if (s1.charAt(index) != s2.charAt(index)) {
                    break;
                }

                index++;
            }

            return s1.substring(0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
