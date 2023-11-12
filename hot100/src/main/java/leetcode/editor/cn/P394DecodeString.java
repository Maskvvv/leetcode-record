package leetcode.editor.cn;
//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
// 示例 1：
//
//
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//
//
// 示例 2：
//
//
//输入：s = "3[a2[c]]"
//输出："accaccacc"
//
//
// 示例 3：
//
//
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//
//
// 示例 4：
//
//
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 30
//
// s 由小写英文字母、数字和方括号
// '[]' 组成
// s 保证是一个 有效 的输入。
// s 中所有整数的取值范围为
// [1, 300]
//
//
// Related Topics 栈 递归 字符串 👍 1631 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

//Java：394. 字符串解码
public class P394DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST

        System.out.println(solution.decodeString("3[a2[c]]"));
        //System.out.println(solution.decodeString("3[a]2[bc]"));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            char[] chars = s.toCharArray();
            stack.addLast(chars[0]);

            for (int i = 1; i < chars.length; i++) {
                char c = chars[i];
                if (c == ']') {
                    StringBuilder substring = new StringBuilder();
                    while (stack.peekLast() != '[') {
                        substring.insert(0, stack.removeLast());
                    }
                    stack.removeLast();

                    StringBuilder timesString = new StringBuilder();
                    while (!stack.isEmpty() && stack.peekLast() >= '0' && stack.peekLast() <= '9') {
                        timesString.insert(0, stack.removeLast());
                    }
                    int times = Integer.valueOf(timesString.toString());

                    for (int m = 0; m < times; m++) {
                        for (int n = 0; n < substring.length(); n++) {
                            stack.addLast(substring.charAt(n));
                        }
                    }

                } else {
                    stack.addLast(c);
                }
            }

            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.append(stack.removeFirst());
            }

            return res.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
