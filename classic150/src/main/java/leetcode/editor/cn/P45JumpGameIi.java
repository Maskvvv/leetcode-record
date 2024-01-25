package leetcode.editor.cn;
//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//
// 0 <= j <= nums[i]
// i + j < n
//
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 1000
// 题目保证可以到达 nums[n-1]
//
//
// Related Topics 贪心 数组 动态规划 👍 2422 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

import java.util.Arrays;

//Java：45. 跳跃游戏 II
public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
        System.out.println(solution.jump(ArrayUtils.generateNumArray("[2,1]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {

            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) continue;

                for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }

            return dp[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
