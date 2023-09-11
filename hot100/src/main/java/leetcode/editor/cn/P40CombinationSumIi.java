package leetcode.editor.cn;
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
//
// Related Topics 数组 回溯 👍 1440 👎 0


import leetcode.editor.cn.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//Java：40. 组合总和 II
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
        System.out.println(solution.combinationSum2(ArrayUtils.generateNumArray("[10,1,2,7,6,1,5]"), 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int pathSum = 0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(candidates, target, 0, new boolean[candidates.length]);
            return res;
        }

        public void backtracking(int[] candidates, int target, int startIndex, boolean[] used) {
            if (pathSum == target) {
                res.add(new ArrayList<>(path));
                return;
            }

            if (pathSum > target) return;

            for (int i = startIndex; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                path.push(candidates[i]);
                pathSum += candidates[i];
                backtracking(candidates, target, i + 1, used);
                pathSum -= path.pop();
                used[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
