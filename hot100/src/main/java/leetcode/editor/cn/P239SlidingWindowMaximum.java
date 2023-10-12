package leetcode.editor.cn;
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。
//
// 返回 滑动窗口中的最大值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
//输入：nums = [1], k = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
// 1 <= k <= nums.length
//
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2551 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Java：239. 滑动窗口最大值
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST

        System.out.println(Arrays.toString(solution.maxSlidingWindow(ArrayUtils.generateNumArray("[1,3,1,2,0,5]"), 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Deque<Integer> increasingQueue = new ArrayDeque<>();
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];

            int index = 0;
            for (int i = 0; i < k; i++) {
                push(nums[i]);
            }

            res[index++] = getMax();
            for (int i = k; i < nums.length; i++) {
                push(nums[i]);
                pop(nums[i - k]);
                res[index++] = getMax();
            }
            return res;
        }

        private void push(int num) {
            while (!increasingQueue.isEmpty() && increasingQueue.peekLast() < num) {
                increasingQueue.removeLast();
            }
            increasingQueue.addLast(num);
        }

        private void pop(int num) {
            if (!increasingQueue.isEmpty() && increasingQueue.peekFirst() == num) {
                increasingQueue.removeFirst();
            }
        }

        private int getMax() {
            return increasingQueue.peekFirst();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
