package leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
//
// Related Topics 数组 回溯 👍 2757 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：46. 全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited;
        public List<List<Integer>> permute(int[] nums) {
            n = nums.length;
            visited = new boolean[n];

            backtracking(nums);
            return res;

        }

        public void backtracking(int[] nums) {
            if (path.size() == n) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (!visited[i]) {
                    visited[i] = true;
                    path.addLast(num);
                    backtracking(nums);
                    path.removeLast();
                    visited[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
