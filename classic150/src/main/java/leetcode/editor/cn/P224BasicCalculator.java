package leetcode.editor.cn;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
//
//
//
// 示例 1：
//
//
//输入：s = "1 + 1"
//输出：2
//
//
// 示例 2：
//
//
//输入：s = " 2-1 + 2 "
//输出：3
//
//
// 示例 3：
//
//
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
// 输入中不存在两个连续的操作符
// 每个数字和运行的计算将适合于一个有符号的 32位 整数
//
//
// Related Topics 栈 递归 数学 字符串 👍 1010 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

//Java：224. 基本计算器
public class P224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new P224BasicCalculator().new Solution();
        // TO TEST
        System.out.println(solution.calculate("1-(     -2)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {

            Deque<Integer> numsStack = new ArrayDeque<>();
            numsStack.add(0);

            Deque<Character> opsStack = new ArrayDeque<>();

            s = s.replace(" ", "");
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                if (c == '(') {
                    opsStack.offerLast(c);
                } else if (c == ')') {
                    while (opsStack.peekLast() != '(') {
                        int res = compute(numsStack, opsStack.pollLast());
                        numsStack.offerLast(res);
                    }

                    opsStack.pollLast();
                } else if (isNum(c)) {
                    int num = 0;
                    for (; i < chars.length && isNum(chars[i]); i++) {
                        num = num * 10 + (chars[i] - '0');
                    }

                    numsStack.offerLast(num);
                    i--;
                } else {
                    if (i > 0 && chars[i - 1] == '(') {
                        numsStack.addLast(0);
                    }

                    while (!opsStack.isEmpty()) {
                        char ops = opsStack.peekLast();
                        if (ops == '(') break;

                        int res = compute(numsStack, opsStack.pollLast());
                        numsStack.offerLast(res);
                    }

                    opsStack.offerLast(c);
                }
            }

            while (!opsStack.isEmpty()) {
                char ops = opsStack.pollLast();

                int res = compute(numsStack, ops);
                numsStack.offerLast(res);
            }

            return numsStack.peekLast();


        }

        public int compute(Deque<Integer> numsStack, char ops) {
            int num2 = numsStack.pollLast();
            int num1 = numsStack.pollLast();

            if (ops == '+') {
                return num1 + num2;
            } else {
                return num1 - num2;
            }

        }

        public boolean isNum(char c) {
            return (c >= '0' && c <= '9');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
