package leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
//
// Related Topics 字符串 动态规划 回溯 👍 2925 👎 0


import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();


        public List<String> generateParenthesis(int n) {
            dfs(n, 0, 0, "");
            return res;
        }

        public void dfs(int n, int l, int r, String path) {
            if (l > n || r > l) return;

            if (l + r == 2 * n) {
                res.add(path);
            }

            dfs(n, l + 1, r, path + "(");
            dfs(n, l, r + 1, path + ")");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
