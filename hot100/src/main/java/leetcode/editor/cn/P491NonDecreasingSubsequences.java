package leetcode.editor.cn;
//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
//
//
// 示例 2：
//
//
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 15
// -100 <= nums[i] <= 100
//
//
// Related Topics 位运算 数组 哈希表 回溯 👍 719 👎 0


import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

//Java：491. 递增子序列
public class P491NonDecreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P491NonDecreasingSubsequences().new Solution();
        // TO TEST
        System.out.println(solution.findSubsequences(ArrayUtils.generateNumArray("[4,6,7,7]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        public List<List<Integer>> findSubsequences(int[] nums) {

            backtracking(nums, 0);
            return res;
        }

        public void backtracking(int[] nums, int startIndex) {

            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = startIndex; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    continue;
                }

                if (path.size() > 0 && path.getLast() > nums[i]) {
                    continue;
                }

                set.add(nums[i]);
                path.addLast(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();

            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
