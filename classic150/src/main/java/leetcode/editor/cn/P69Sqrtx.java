package leetcode.editor.cn;
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
// 示例 1：
//
//
//输入：x = 4
//输出：2
//
//
// 示例 2：
//
//
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//
//
// 提示：
//
//
// 0 <= x <= 2³¹ - 1
//
//
// Related Topics 数学 二分查找 👍 1478 👎 0

//Java：69. x 的平方根
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        // TO TEST
        System.out.println(solution.mySqrt(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int l = 0, r = x;

            int res = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long sqr = (long) mid * mid;
                if (sqr > x) {
                    r = mid - 1;
                } else if (sqr < x) {
                    l = mid + 1;
                } else {
                    return mid;
                }

            }

            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
