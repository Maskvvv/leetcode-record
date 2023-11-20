package leetcode.editor.cn;
//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// n 是一个整数
// 要么 x 不为零，要么 n > 0 。
// -104 <= xⁿ <= 104
//
//
// Related Topics 递归 数学 👍 1276 👎 0

//Java：50. Pow(x, n)
public class P50PowxN {
    public static void main(String[] args) {
        Solution solution = new P50PowxN().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                x = 1 / x;
                n = -n;
            }

            return myPower(x, n);
        }

        public double myPower(double x, int n) {
            if (n == 0) return x;

            double y = myPower(x, n / 2);

            return n % 2 == 0 ? y * y : y * y * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
