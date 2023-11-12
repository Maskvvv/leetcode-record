package leetcode.editor.cn;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10⁶ <= nums1[i], nums2[i] <= 10⁶
//
//
// Related Topics 数组 二分查找 分治 👍 6877 👎 0

//Java：4. 寻找两个正序数组的中位数
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;


            }
            int m = nums1.length;
            int n = nums2.length;

            int sLength = (m + n + 1) / 2;

            int left = 0, right = m;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;

                int nums2Right = sLength - mid;
                if (nums1[mid - 1] > nums2[nums2Right]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            int nums1Left = left - 1 < 0 ? min : nums1[left - 1];
            int nums1right = left >= m ? max : nums1[left];
            int nums2Left = sLength - left - 1 < 0 ? min : nums2[sLength - left - 1];
            int nums2right = sLength - left >= n ? max : nums2[sLength - left];


            if ((m + n) % 2 == 0) {
                return ((double) Math.max(nums1Left, nums2Left) + Math.min(nums1right, nums2right)) / 2;
            } else {
                return Math.max(nums1Left, nums2Left);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
