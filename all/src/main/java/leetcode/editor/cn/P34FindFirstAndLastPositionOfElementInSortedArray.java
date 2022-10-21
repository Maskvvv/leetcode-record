package leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
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
// Related Topics 数组 二分查找 👍 1641 👎 0


//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] ints = solution.searchRange(new int[]{2, 2}, 3);
        System.out.println(ints[0] + " "+ ints[1]);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int n = nums.length;


            int[] res = new int[2];

            int left = 0, right = nums.length;

            while (left < right) {
                int middle = left + (right - left) / 2;

                if (nums[middle] == target) {
                    right = middle;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            res[0] = left;

            left = 0;
            right = nums.length;
            while (left < right) {
                int middle = left + (right - left) / 2;

                if (nums[middle] == target) {
                    left = middle + 1;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            res[1] = left - 1;

            if (res[0] >= n || res[1] >= n|| nums[res[0]] != target || nums[res[1]] != target) {
                res[0] = -1;
                res[1] = -1;
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
