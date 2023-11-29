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
// Related Topics 字符串 动态规划 回溯 👍 3448 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：22. 括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            backtracking(n, 0, 0);
            return res;
        }

        public void backtracking(int n, int l, int r) {
            if (path.length() == n * 2) {
                res.add(path.toString());
                return;
            }

            if (l < n) {
                path.append('(');
                backtracking(n, l + 1, r);
                path.deleteCharAt(path.length() - 1);
            }

            if (r < l) {
                path.append(')');
                backtracking(n, l, r + 1);
                path.deleteCharAt(path.length() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
