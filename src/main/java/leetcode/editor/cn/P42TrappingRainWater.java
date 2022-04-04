package leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3301 👎 0


//Java：接雨水
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            //int n = height.length;
            //if (n < 3) return 0;
            //Deque<Integer> stack = new LinkedList<>();
            //Map<Integer, Integer> map = new HashMap<>();
            //for (int i = 0; i < n; i++) {
            //    int pre = i;
            //    if (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
            //        Integer pop = stack.pop();
            //        pre = pop;
            //        map.put(pop, i);
            //
            //    }
            //    for (int j = pre + 1; j < i; j++) {
            //        map.remove(j);
            //
            //    }
            //    stack.push(i);
            //}
            //int res = 0;
            //for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //    int start = entry.getKey();
            //    int end = entry.getValue();
            //    res += (end - start - 1) * height[start];
            //    for (int i = start + 1; i < end; i++) {
            //
            //    }
            //}
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
