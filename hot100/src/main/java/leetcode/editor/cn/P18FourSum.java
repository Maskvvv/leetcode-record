package leetcode.editor.cn;
//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//
// 0 <= a, b, c, d < n
// a、b、c 和 d 互不相同
// nums[a] + nums[b] + nums[c] + nums[d] == target
//
//
// 你可以按 任意顺序 返回答案 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
//
//
// Related Topics 数组 双指针 排序 👍 1768 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：18. 四数之和
public class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
        System.out.println(solution.fourSum(ArrayUtils.generateNumArray("[1000000000,1000000000,1000000000,1000000000]"), -294967296));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 4) return res;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                    long subTarget = (long) target - nums[i] - nums[j];
                    int left = j + 1, right = nums.length - 1;

                    while (left < right) {

                        long sum = nums[left] + nums[right];
                        if (sum == subTarget) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            right--;

                            while (left < right && nums[left] == nums[left - 1]) left++;
                            while (left < right && nums[right] == nums[right + 1]) right--;

                        } else if (sum > subTarget) {
                            right--;
                        } else {
                            left++;
                        }
                    }

                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
