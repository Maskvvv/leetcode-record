package leetcode.editor.cn;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
// 示例 1:
//
//
//
//
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//
//
// 示例 2：
//
//
//
//
//输入： heights = [2,4]
//输出： 4
//
//
//
// 提示：
//
//
// 1 <= heights.length <=10⁵
// 0 <= heights[i] <= 10⁴
//
//
// Related Topics 栈 数组 单调栈 👍 2587 👎 0

import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：84. 柱状图中最大的矩形
public class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
        System.out.println(solution.largestRectangleArea(ArrayUtils.generateNumArray("[8,6,4,2]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int res = 0;

            int[] newHeights = new int[heights.length + 2];
            for (int i = 0; i < heights.length; i++) {
                newHeights[i + 1] = heights[i];
            }
            heights = newHeights;

            Deque<Integer> stack = new ArrayDeque<>();
            stack.add(0);

            for (int i = 1; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
                    int mid = stack.removeLast();
                    int left = stack.getLast();
                    int right = i;
                    int height = heights[mid];
                    int width = right - left - 1;
                    res = Math.max(res, height * width);
                }
                stack.addLast(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
