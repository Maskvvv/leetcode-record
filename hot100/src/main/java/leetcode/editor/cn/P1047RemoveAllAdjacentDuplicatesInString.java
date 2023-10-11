package leetcode.editor.cn;
//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
//
//
//
// 示例：
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
//
//
//
//
// 提示：
//
//
// 1 <= S.length <= 20000
// S 仅由小写英文字母组成。
//
//
// Related Topics 栈 字符串 👍 575 👎 0

//Java：1047. 删除字符串中的所有相邻重复项
public class P1047RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {

                if (stringBuilder.length() == 0) {
                    stringBuilder.append(c);
                } else if (stringBuilder.charAt(stringBuilder.length() - 1) == c) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    stringBuilder.append(c);
                }
            }

            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
