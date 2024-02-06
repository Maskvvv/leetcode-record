package leetcode.editor.cn;
//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//
// 示例 2：
//
//
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// nums[i] 不是 0 就是 1
// 0 <= k <= nums.length
//
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 677 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

//Java：1004. 最大连续1的个数 III
public class P1004MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new P1004MaxConsecutiveOnesIii().new Solution();
        // TO TEST
        System.out.println(solution.longestOnes(ArrayUtils.generateNumArray("[1,1,1,0,0,0,1,1,1,1,0]"), 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int res = 0;
            int l = 0, r = 0;
            int count0 = 0;

            for (; r < nums.length; r++) {
                if (nums[r] == 0) {
                    count0++;
                }

                while (count0 > k) {
                    if (nums[l] == 0) {
                        count0--;
                    }

                    l++;
                }

                res = Math.max(res, r - l + 1);
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
