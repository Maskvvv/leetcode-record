package leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
//
// Related Topics 数组 回溯 👍 1238 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
        int[] nums = {1,1,2};
        System.out.println(solution.permuteUnique(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        int n;


        public List<List<Integer>> permuteUnique(int[] nums) {
            n = nums.length;
            boolean[] used = new boolean[n];
            Arrays.fill(used, false);
            Arrays.sort(nums);
            backtracking(nums, used);

            return res;
        }

        public void backtracking(int[] nums, boolean[] used) {
            if (path.size() == n) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

                if (used[i]) continue;
                int num = nums[i];
                used[i] = true;
                path.push(num);

                backtracking(nums, used);

                path.pop();
                used[i] = false;

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
