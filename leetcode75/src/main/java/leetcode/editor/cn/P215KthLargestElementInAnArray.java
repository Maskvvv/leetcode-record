package leetcode.editor.cn;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2412 👎 0

import java.util.Random;

//Java：215. 数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            int target = n - k;

            int left = 0;
            int right = n - 1;

            while (true) {
                int pivot = partition(nums, left, right);
                if (pivot > target) {
                    right = pivot - 1;
                } else if (pivot < target) {
                    left = pivot + 1;
                } else {
                    return nums[pivot];
                }
            }
        }

        public int partition(int[] nums, int left, int right) {
            int randomIndex = left + random.nextInt(right - left + 1);
            swap(nums, randomIndex, left);

            int l = left + 1, r = right;

            while (true) {
                while (l <= r && nums[l] < nums[left]) {
                    l++;
                }

                while (l <= r && nums[r] > nums[left]) {
                    r--;
                }

                if (l >= r) break;

                swap(nums, l, r);
                l++;
                r--;
            }

            swap(nums, left, r);

            return r;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
