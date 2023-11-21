package leetcode.editor.cn;
//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//
//
//
// 示例 1：
//
//
//输入:a = "11", b = "1"
//输出："100"
//
// 示例 2：
//
//
//输入：a = "1010", b = "1011"
//输出："10101"
//
//
//
// 提示：
//
//
// 1 <= a.length, b.length <= 10⁴
// a 和 b 仅由字符 '0' 或 '1' 组成
// 字符串如果不是 "0" ，就不含前导零
//
//
// Related Topics 位运算 数学 字符串 模拟 👍 1126 👎 0

//Java：67. 二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
        System.out.println(solution.addBinary("11", "1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int m = a.length() - 1, n = b.length() - 1;
            if (m == -1) return b;
            if (n == -1) return a;

            StringBuilder res = new StringBuilder();
            char[] chars1 = a.toCharArray();
            char[] chars2 = b.toCharArray();
            int power = 0;
            while (m >= 0 || n >= 0) {
                char c1 = m < 0 ? '0' : chars1[m--];
                char c2 = n < 0 ? '0' : chars2[n--];
                int sum = (c1 - '0') + (c2 - '0') + power;

                res.insert(0, sum % 2);
                power = sum / 2;
            }

            if (power == 1) res.insert(0, "1");

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
