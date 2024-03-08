package leetcode.editor.cn;
//泰波那契序列 Tn 定义如下：
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
//
//
//
// 示例 1：
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
//
//
// 示例 2：
//
// 输入：n = 25
//输出：1389537
//
//
//
//
// 提示：
//
//
// 0 <= n <= 37
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
//
//
// Related Topics 记忆化搜索 数学 动态规划 👍 297 👎 0

//Java：1137. 第 N 个泰波那契数
public class P1137NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new P1137NThTribonacciNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            int t1 = 0, t2 = 1, t3 = 1;
            if (n == 0) {
                return t1;
            } else if (n == 1) {
                return t2;
            } else if (n == 2) {
                return t3;
            }

            for (int i = 3; i <= n; i++) {
                int next = t1 + t2 + t3;
                t1 = t2;
                t2 = t3;
                t3 = next;
            }

            return t3;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
