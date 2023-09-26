package leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
// 示例 1:
//
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
//
// 示例 2:
//
//
//输入: nums = [0]
//输出: [0]
//
//
//
// 提示:
//
//
//
// 1 <= nums.length <= 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
//
//
//
//
// 进阶：你能尽量减少完成的操作次数吗？
//
// Related Topics 数组 双指针 👍 2180 👎 0

import leetcode.editor.cn.model.TreeNode;
import leetcode.editor.cn.utils.ArrayUtils;

//Java：283. 移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        solution.moveZeroes(ArrayUtils.generateNumArray("[4,2,4,0,0,3,0,5,1,0]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            if (n < 2) return;
            int start = 0, end = 0;

            while (end < n) {
                if (nums[end] != 0) {
                    swap(nums, start, end);
                    start++;
                }
                end++;
            }

        }

        private void swap(int[] nums, int start, int end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
