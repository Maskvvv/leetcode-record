package leetcode.editor.cn;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1652 👎 0


import java.util.Arrays;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        int target;

        public int findKthLargest(int[] nums, int k) {
            this.target = nums.length - k;
            quickSortRandomPivot(nums, 0, nums.length - 1);
            return nums[nums.length - k];
        }

        public void quickSortRandomPivot(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int i = left, j = right;
            int randomIndex = left + 1 + (int) (Math.random() * (right - left));
            swap(nums, left, randomIndex);
            int pivot = nums[left];

            while (i < j) {
                while (nums[j] >= pivot && i < j) {
                    j--;
                }
                nums[i] = nums[j];
                while (nums[i] <= pivot && i < j) {
                    i++;
                }
                nums[j] = nums[i];
            }

            nums[i] = pivot;

            if (i < target) {
                quickSortRandomPivot(nums, i + 1, right);
            } else if (i > target) {
                quickSortRandomPivot(nums, left, i - 1);
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
