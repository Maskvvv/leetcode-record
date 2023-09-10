package leetcode.editor.cn;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
//
// Related Topics 位运算 数组 回溯 👍 2138 👎 0


import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：78. 子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
        System.out.println(solution.subsets(ArrayUtils.generateNumArray("[1,2,3]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        public List<List<Integer>> subsets(int[] nums) {

            backtracking(nums, 0);
            return res;
        }

        public void backtracking(int[] nums, int startIndex) {
            res.add(new ArrayList<>(path));

            for (int i = startIndex; i < nums.length; i++) {
                path.addLast(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
