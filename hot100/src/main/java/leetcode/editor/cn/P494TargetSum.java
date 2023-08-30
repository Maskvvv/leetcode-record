package leetcode.editor.cn;
//给你一个非负整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
// left + right = sum
// right = sum - left
// left - right = target
// left = target + right = target + sum - left
// left = (target + sum) / 2
//
// 示例 1：
//
//
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//
//
// 示例 2：
//
//
//输入：nums = [1], target = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000
//
//
// Related Topics 数组 动态规划 回溯 👍 1729 👎 0


import leetcode.editor.cn.utils.ArrayUtils;

//Java：494. 目标和
public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        int[] numArray = ArrayUtils.generateNumArray("[100,100]");
        System.out.println(solution.findTargetSumWays(numArray, -400));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            target = Math.abs(target);
            if (n == 1) return (nums[0] == target) ? 1 : 0;

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (((target + sum) & 1) == 1) return 0;

            int left = (target + sum) / 2;

            int[] dp = new int[left + 1];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {

                for (int j = left; j >= nums[i]; j--) {

                    dp[j] += dp[j - nums[i]];
                }

            }

            return dp[left];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
