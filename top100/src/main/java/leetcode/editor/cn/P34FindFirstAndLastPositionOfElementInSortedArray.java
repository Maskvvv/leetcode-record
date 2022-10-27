package leetcode.editor.cn;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
//
// Related Topics 数组 二分查找 👍 1971 👎 0


//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        solution.searchRange(new int[]{2,2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int n = nums.length;
            if (n < 1) return new int[]{-1, -1};

            int[] res = new int[]{-1, -1};

            int left = 0, right = n;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (left < n && target == nums[left]) {
                res[0] = left;
            } else {
                return res;
            }



            left = 0;
            right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            res[1] = nums[left - 1] == target ? left - 1 : -1;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
