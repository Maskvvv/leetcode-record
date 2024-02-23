package leetcode.editor.cn;
//给你一个二进制数组 nums ，你需要从中删掉一个元素。
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
//
// 如果不存在这样的子数组，请返回 0 。
//
//
//
// 提示 1：
//
//
//输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
//
// 示例 2：
//
//
//输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
//
// 示例 3：
//
//
//输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// nums[i] 要么是 0 要么是 1 。
//
//
// Related Topics 数组 动态规划 滑动窗口 👍 120 👎 0

//Java：1493. 删掉一个元素以后全为 1 的最长子数组
public class P1493LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        Solution solution = new P1493LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            int res = 0;
            int l = 0, r = 0;
            int count1 = 0;
            int count0 = 0;

            for (; r < nums.length; r++) {
                if (nums[r] == 0) {
                    count0++;
                } else {
                    count1++;
                }

                while (count0 > 1) {
                    if (nums[l] == 0) {
                        count0--;
                    } else {
                        count1--;
                    }

                    l++;
                }

                if (count0 == 0) {
                    res = Math.max(res, count1 - 1);
                } else {
                    res = Math.max(res, count1);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
