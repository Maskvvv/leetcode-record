package leetcode.editor.cn;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
//
// Related Topics 回溯 👍 1481 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：77. 组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res;
        Deque<Integer> path;
        int k;
        int n;

        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            path = new ArrayDeque<>();
            this.n = n;
            this.k = k;
            backtracking(1);

            return res;
        }

        public void backtracking(int startIndex) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // k - path.size() <= n - i + 1 => i <= n + 1 - k + path.size()
            // i <= n - (k - stack.size()) + 1
            for (int i = startIndex; i <= n + 1 - k + path.size(); i++) {
                path.push(i);

                backtracking(i + 1);

                path.pop();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
