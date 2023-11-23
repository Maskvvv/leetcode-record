package leetcode.editor.cn;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是质因子只包含 2、3 和 5 的正整数。
//
//
//
// 示例 1：
//
//
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1690
//
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 1131 👎 0

//Java：264. 丑数 II
public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        // TO TEST
        System.out.println(solution.nthUglyNumber(1407));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {

            int[] ans = new int[n + 1];
            ans[1] = 1;

            for (int i2 = 1, i3 = 1, i5 = 1, idx = 2; idx <= n ; idx++) {

                int n2 = ans[i2] * 2, n3 = ans[i3] * 3, n5 = ans[i5] * 5;

                int min = Math.min(n2, Math.min(n3, n5));

                ans[idx] = min;

                if (n2 == min) i2++;
                if (n3 == min) i3++;
                if (n5 == min) i5++;
            }

            return ans[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
