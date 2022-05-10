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
// Related Topics 数组 双指针 👍 1578 👎 0


import java.util.Arrays;

//Java：移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        //int[] ints = {0, 0, 1, 0, 3, 0, 12, 0, 0, 45};
        int[] ints = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        //int[] ints = {1, 3};
        solution.moveZeroes(ints);

        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }

            while (left < n) {
                nums[left++] = 0;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
